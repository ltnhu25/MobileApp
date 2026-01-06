package com.example.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.login.auth.FirebaseAuthManager
import com.example.login.ui.screen.AuthScreen

class MainActivity : ComponentActivity() {

    private lateinit var authManager: FirebaseAuthManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        authManager = FirebaseAuthManager(this)

        setContent {
            AuthScreen(
                onLoginClick = {
                    startActivityForResult(
                        authManager.signInIntent(),
                        FirebaseAuthManager.RC_SIGN_IN
                    )
                },
                onLogoutClick = {
                    authManager.signOut()   // 🔥 gọi logout ở đây
                }
            )
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        authManager.handleResult(requestCode, data)
    }
}
