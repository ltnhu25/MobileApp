package com.example.login.auth

import android.app.Activity
import android.content.Intent
import com.example.login.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics


class FirebaseAuthManager(private val activity: Activity) {

    companion object {
        const val RC_SIGN_IN = 1001
    }

    private val auth = FirebaseAuth.getInstance()
    private val analytics = FirebaseAnalytics.getInstance(activity)

    private val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(activity.getString(R.string.default_web_client_id))
        .requestEmail()
        .build()

    private val googleClient = GoogleSignIn.getClient(activity, gso)

    fun signInIntent(): Intent = googleClient.signInIntent

    fun handleResult(requestCode: Int, data: Intent?) {
        if (requestCode != RC_SIGN_IN) return

        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        try {
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)

            auth.signInWithCredential(credential)
                .addOnCompleteListener(activity) { result ->
                    if (result.isSuccessful) {

                        val email = auth.currentUser?.email

                        // 🔥 GHI NHẬN EVENT LOGIN
                        val bundle = Bundle().apply {
                            putString(FirebaseAnalytics.Param.METHOD, "google")
                        }
                        analytics.logEvent(FirebaseAnalytics.Event.LOGIN, bundle)

                        AuthState.success(
                            "Hi $email\nWelcome to UTHSmartTasks"
                        )
                    } else {
                        AuthState.error("Authentication Failed")
                    }
                }
        } catch (e: Exception) {
            AuthState.error("User canceled the Google sign-in process.")
        }
    }
    fun signOut() {
        auth.signOut()          // Logout Firebase
        googleClient.signOut() // Logout Google
        AuthState.clear()      // Xoá trạng thái UI
    }

}
