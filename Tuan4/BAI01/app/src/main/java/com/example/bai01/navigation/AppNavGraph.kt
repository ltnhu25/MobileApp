package com.example.bai01.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.bai01.screens.*

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(Screen.Welcome.route) { WelcomeScreen(navController) }
        composable(Screen.List.route) { ComponentListScreen(navController) }
        composable(Screen.Text.route) { TextDetailScreen() }
        composable(Screen.Image.route) { ImageDetailScreen() }
        composable(Screen.TextField.route) { TextFieldScreen() }
        composable(Screen.Layout.route) { LayoutScreen() }
        composable(Screen.Custom.route) { CustomUIScreen() }
    }
}
