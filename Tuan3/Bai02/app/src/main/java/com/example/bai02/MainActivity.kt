package com.example.bai02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.bai02.screen.PaymentScreen
import com.example.bai02.ui.theme.Bai02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bai02Theme {
                PaymentScreen()
            }
        }
    }
}
