package com.example.bai01.ui.screen

import android.app.Activity
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bai01.R
import com.example.bai01.auth.FirebaseAuthManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException

@Composable
fun LoginScreen(
    navController: NavController,
    authManager: FirebaseAuthManager
) {
    val context = LocalContext.current
    val activity = context as Activity

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                val account = task.getResult(ApiException::class.java)
                val idToken = account.idToken!!

                authManager.firebaseAuthWithGoogle(idToken) { success, error ->
                    if (success) {
                        navController.navigate("profile") {
                            popUpTo("login") { inclusive = true }
                        }
                    } else {
                        Toast.makeText(
                            context,
                            error ?: "Login failed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } catch (e: ApiException) {
                Toast.makeText(context, "Google sign in failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.height(60.dp))

        Image(
            painter = painterResource(id = R.drawable.logo_uth),
            contentDescription = null,
            modifier = Modifier.size(140.dp)
        )

        Spacer(Modifier.height(16.dp))

        Text("SmartTasks", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("A simple and efficient to-do app", color = Color.Gray)

        Spacer(Modifier.height(40.dp))

        Text("Welcome", fontSize = 20.sp, fontWeight = FontWeight.Medium)
        Text("Ready to explore? Log in to get started.", color = Color.Gray)

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = {
                val intent = authManager.getGoogleSignInClient().signInIntent
                launcher.launch(intent)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD7ECFF)),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_google),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
            Spacer(Modifier.width(8.dp))
            Text("SIGN IN WITH GOOGLE", color = Color.Black)
        }

        Spacer(Modifier.weight(1f))

        Text("© UTHSmartTasks", color = Color.Gray, fontSize = 12.sp)
    }
}
