package com.example.bai01.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.*

@Composable
fun LayoutScreen() {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        repeat(4) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                repeat(3) {
                    Box(
                        modifier = Modifier.size(80.dp)
                            .background(Color(0xFF7DA7FF), RoundedCornerShape(12.dp))
                    )
                }
            }
            Spacer(Modifier.height(12.dp))
        }
    }
}
