package com.example.bai01.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bai01.auth.FirebaseAuthManager
import com.example.bai01.ui.screen.LoginScreen
import com.example.bai01.ui.screen.ProfileScreen

@Composable
fun AppNav() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val authManager = FirebaseAuthManager(context as android.app.Activity)

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController, authManager)
        }
        composable("profile") {
            ProfileScreen(navController)
        }
    }
}
