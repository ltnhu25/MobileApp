package com.example.bai01.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*

@Composable
fun CustomUIScreen() {
    var rating by remember { mutableStateOf(0) }

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Custom Rating", fontSize = 20.sp)

        Spacer(Modifier.height(16.dp))

        Row {
            for (i in 1..5) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = if (i <= rating) Color.Yellow else Color.Gray,
                    modifier = Modifier.size(36.dp)
                        .clickable { rating = i }
                )
            }
        }

        Spacer(Modifier.height(8.dp))
        Text("Rating: $rating")
    }
}
