package com.example.bai01.auth

import android.app.Activity
import android.util.Log
import com.example.bai01.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider

class FirebaseAuthManager(private val activity: Activity) {

    private val auth: FirebaseAuth
        get() = FirebaseAuth.getInstance()

    fun getGoogleSignInClient(): GoogleSignInClient {
        val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(activity.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        return GoogleSignIn.getClient(activity, options)
    }

    fun firebaseAuthWithGoogle(
        idToken: String,
        onResult: (Boolean, String?) -> Unit
    ) {
        try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            auth.signInWithCredential(credential)
                .addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        Log.d("AUTH", "Firebase login OK: ${auth.currentUser?.email}")
                        onResult(true, null)
                    } else {
                        Log.e("AUTH", "Firebase login FAIL", task.exception)
                        onResult(false, task.exception?.message)
                    }
                }
        } catch (e: Exception) {
            Log.e("AUTH", "Firebase init error", e)
            onResult(false, e.message)
        }
    }

    fun getCurrentUser() = auth.currentUser
}
