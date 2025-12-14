package com.example.bai02

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
import com.example.bai02.ui.theme.Bai02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bai02Theme {
                Scaffold { padding ->
                    Practice03(modifier = Modifier.padding(padding))
                }
            }
        }
    }
}

@Composable
fun Practice03(modifier: Modifier = Modifier) {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf("+") }

    fun calculate() {
        val a = num1.toDoubleOrNull()
        val b = num2.toDoubleOrNull()
        result = if (a != null && b != null) {
            when (operator) {
                "+" -> (a + b).toString()
                "-" -> (a - b).toString()
                "*" -> (a * b).toString()
                "/" -> if (b != 0.0) (a / b).toString() else "Lỗi"
                else -> ""
            }
        } else ""
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Thực hành 03")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = num1,
            onValueChange = {
                num1 = it
                calculate()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            OperatorButton("+", Color(0xFFE53935)) {
                operator = "+"
                calculate()
            }
            OperatorButton("-", Color(0xFFFBC02D)) {
                operator = "-"
                calculate()
            }
            OperatorButton("*", Color(0xFF5E35B1)) {
                operator = "*"
                calculate()
            }
            OperatorButton("/", Color.Black) {
                operator = "/"
                calculate()
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = num2,
            onValueChange = {
                num2 = it
                calculate()
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Kết quả: $result")
    }
}

@Composable
fun OperatorButton(
    text: String,
    color: Color,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = color),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.size(56.dp)
    ) {
        Text(text = text, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun Practice03Preview() {
    Bai02Theme {
        Practice03()
    }
}
