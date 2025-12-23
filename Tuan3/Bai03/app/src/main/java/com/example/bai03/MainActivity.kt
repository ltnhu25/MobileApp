package com.example.bai03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bai03.screen.MainScreen
import com.example.bai03.ui.theme.Bai03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bai03Theme {
                MainScreen()
            }
        }
    }
}
