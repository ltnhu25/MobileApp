package com.example.bai03.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bai03.model.*

@Composable
fun ManageScreen(manager: LibraryManager) {

    var selectedUser by remember { mutableStateOf(manager.users.first()) }
    var selectedBooks by remember { mutableStateOf(setOf<Int>()) }

    Column(modifier = Modifier.padding(16.dp)) {

        Text("Hệ thống\nQuản lý Thư viện", style = MaterialTheme.typography.titleLarge)

        Spacer(Modifier.height(16.dp))
        Text("Nhân viên")

        DropdownMenuBox(
            selectedUser = selectedUser,
            users = manager.users,
            onUserSelected = { selectedUser = it }
        )

        Spacer(Modifier.height(16.dp))
        Text("Danh sách sách")

        manager.books.forEach { book ->
            Row {
                Checkbox(
                    checked = selectedBooks.contains(book.id),
                    onCheckedChange = {
                        selectedBooks =
                            if (it) selectedBooks + book.id else selectedBooks - book.id
                    }
                )
                Text(book.name)
            }
        }

        Spacer(Modifier.height(16.dp))
        Button(onClick = {
            manager.books
                .filter { selectedBooks.contains(it.id) }
                .forEach { manager.borrowBook(it, selectedUser) }
        }) {
            Text("Thêm")
        }
    }
}

@Composable
fun DropdownMenuBox(
    selectedUser: User,
    users: List<User>,
    onUserSelected: (User) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Button(onClick = { expanded = true }) {
            Text(selectedUser.name)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            users.forEach {
                DropdownMenuItem(
                    text = { Text(it.name) },
                    onClick = {
                        onUserSelected(it)
                        expanded = false
                    }
                )
            }
        }
    }
}
