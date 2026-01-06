package com.example.bai01.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.bai01.R
import com.example.bai01.navigation.Screen

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.compose_logo),
            contentDescription = null,
            modifier = Modifier.size(120.dp)
        )

        Spacer(Modifier.height(20.dp))

        Text("Jetpack Compose", fontSize = 22.sp, fontWeight = FontWeight.Bold)

        Spacer(Modifier.height(32.dp))

        Button(
            onClick = { navController.navigate(Screen.List.route) },
            shape = RoundedCornerShape(24.dp)
        ) {
            Text("I'm ready")
        }
    }
}
