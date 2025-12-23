package com.example.bai03.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.bai03.model.*

@Composable
fun MainScreen() {

    val manager = remember {
        LibraryManager().apply {
            addUser(User(1, "Nguyen Van A"))
            addUser(User(2, "Tran Thi B"))
            addBook(Book(1, "Sách 01"))
            addBook(Book(2, "Sách 02"))
        }
    }

    var currentTab by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentTab == 0,
                    onClick = { currentTab = 0 },
                    icon = { Icon(Icons.Default.Home, null) },
                    label = { Text("Quản lý") }
                )
                NavigationBarItem(
                    selected = currentTab == 1,
                    onClick = { currentTab = 1 },
                    icon = { Icon(Icons.Default.List, null) },
                    label = { Text("DS Sách") }
                )
                NavigationBarItem(
                    selected = currentTab == 2,
                    onClick = { currentTab = 2 },
                    icon = { Icon(Icons.Default.Person, null) },
                    label = { Text("Nhân viên") }
                )
            }
        }
    ) { padding ->
        when (currentTab) {
            0 -> ManageScreen(manager)
            1 -> BookListScreen(manager)
            2 -> UserScreen(manager)
        }
    }
}
