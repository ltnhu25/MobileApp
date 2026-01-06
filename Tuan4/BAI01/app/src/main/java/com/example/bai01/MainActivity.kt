package com.example.bai01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bai01.navigation.AppNavGraph
import com.example.bai01.ui.theme.Bai01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bai01Theme {
                AppNavGraph()
            }
        }
    }
}
