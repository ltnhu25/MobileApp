package com.example.uth.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uth.ui.components.TaskItem
import com.example.uth.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(
    viewModel: TaskViewModel,
    onAddClick: () -> Unit
) {
    val tasks by viewModel.tasks.observeAsState(emptyList())

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Icon(Icons.Default.Add, contentDescription = null)
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(tasks) { task ->
                TaskItem(task)
            }
        }
    }
}
