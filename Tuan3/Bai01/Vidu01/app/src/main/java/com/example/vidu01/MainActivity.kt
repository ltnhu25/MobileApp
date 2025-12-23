package com.example.vidu01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vidu01.ui.theme.Vidu01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Vidu01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    UserInfoScreen(
                        name = "Nguyễn Văn A",
                        email = null, // Nullable ở đây
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun UserInfoScreen(
    name: String,
    email: String?,          // Biến nullable
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(text = "Họ tên: $name")

        // Xử lý null bằng Elvis operator
        Text(
            text = "Email: ${email ?: "Chưa cập nhật email"}"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserInfoPreview() {
    Vidu01Theme {
        UserInfoScreen(
            name = "Nguyễn Văn A",
            email = null
        )
    }
}
