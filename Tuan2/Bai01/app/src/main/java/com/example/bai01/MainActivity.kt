package com.example.bai01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bai01.ui.theme.Bai01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bai01Theme {
                Scaffold { padding ->
                    Practice02(modifier = Modifier.padding(padding))
                }
            }
        }
    }
}

@Composable
fun Practice02(modifier: Modifier = Modifier) {
    var input by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }
    var numbers by remember { mutableStateOf(listOf<Int>()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Thực hành 02")

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = input,
                onValueChange = { input = it },
                placeholder = { Text("Nhập vào số lượng") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                val n = input.toIntOrNull()
                if (n == null || n <= 0) {
                    error = "Dữ liệu bạn nhập không hợp lệ"
                    numbers = emptyList()
                } else {
                    error = ""
                    numbers = (1..n).toList()
                }
            }) {
                Text("Tạo")
            }
        }

        if (error.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = error, color = Color.Red)
        }

        Spacer(modifier = Modifier.height(24.dp))

        numbers.forEach { number ->
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Text(text = number.toString(), color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPractice02() {
    Bai01Theme {
        Practice02()
    }
}
