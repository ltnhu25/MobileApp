package com.example.login.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import com.example.login.auth.AuthState
import com.example.login.ui.component.MessageBox

@Composable
fun AuthScreen(
    onLoginClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    val message by AuthState::message
    val isSuccess by AuthState::isSuccess

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = onLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2196F3)
            )
        ) {
            Text("Login by Gmail", color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        if (isSuccess == true) {
            Button(
                onClick = onLogoutClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(25.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF44336)
                )
            ) {
                Text("Logout", color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (isSuccess != null) {
            MessageBox(
                success = isSuccess!!,
                text = message
            )
        }
    }
}

