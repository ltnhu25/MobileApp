package com.example.bai01.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.*

@Composable
fun TextDetailScreen() {
    val text = buildAnnotatedString {
        append("The ")
        withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)) { append("quick ") }
        withStyle(SpanStyle(color = Color(0xFFB36A00), fontWeight = FontWeight.Bold)) { append("Brown ") }
        append("fox jumps ")
        withStyle(SpanStyle(fontStyle = FontStyle.Italic)) { append("over ") }
        append("the lazy dog.")
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text, fontSize = 20.sp)
    }
}
