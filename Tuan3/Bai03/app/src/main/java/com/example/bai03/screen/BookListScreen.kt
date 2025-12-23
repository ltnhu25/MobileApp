package com.example.bai03.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.bai03.model.*

@Composable
fun BookListScreen(manager: LibraryManager) {
    Column(Modifier.padding(16.dp)) {
        Text("Danh sách sách", style = MaterialTheme.typography.titleLarge)

        manager.books.forEach {
            Text(
                "${it.name} - " +
                        if (it.isBorrowed())
                            "Đã mượn bởi ${it.borrowedBy?.name}"
                        else "Chưa mượn"
            )
        }
    }
}
