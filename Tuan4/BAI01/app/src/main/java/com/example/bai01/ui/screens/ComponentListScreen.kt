package com.example.bai01.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.bai01.navigation.Screen

@Composable
fun ComponentListScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        item {
            Text("UI Components List", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(16.dp))
        }

        item { itemCard("Text", "Displays text") { navController.navigate(Screen.Text.route) } }
        item { itemCard("Image", "Displays an image") { navController.navigate(Screen.Image.route) } }
        item { itemCard("TextField", "Input field") { navController.navigate(Screen.TextField.route) } }
        item { itemCard("Row / Column", "Layout elements") { navController.navigate(Screen.Layout.route) } }
        item { itemCard("Tự tìm hiểu", "Custom UI component") { navController.navigate(Screen.Custom.route) } }
    }
}

@Composable
private fun itemCard(title: String, desc: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp).clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFD6E9FF))
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(title, fontWeight = FontWeight.Bold)
            Text(desc, fontSize = 13.sp)
        }
    }
}
