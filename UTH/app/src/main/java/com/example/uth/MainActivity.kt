package com.example.uth

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.uth.data.local.TaskDatabase
import com.example.uth.data.repository.TaskRepository
import com.example.uth.ui.screens.AddTaskScreen
import com.example.uth.ui.screens.TaskListScreen
import com.example.uth.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = TaskDatabase.getInstance(this)
        val repository = TaskRepository(db.taskDao())
        val viewModel = TaskViewModel(repository)

        setContent {
            var showAdd by remember { mutableStateOf(false) }

            if (showAdd) {
                AddTaskScreen(viewModel) {
                    showAdd = false
                }
            } else {
                TaskListScreen(viewModel) {
                    showAdd = true
                }
            }
        }
    }
}
