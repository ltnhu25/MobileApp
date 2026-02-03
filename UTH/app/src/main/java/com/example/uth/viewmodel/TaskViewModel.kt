package com.example.uth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uth.data.local.TaskEntity
import com.example.uth.data.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel(
    private val repository: TaskRepository
) : ViewModel() {

    val tasks = repository.getAllTasks()

    fun addTask(title: String, description: String) {
        viewModelScope.launch {
            repository.insert(
                TaskEntity(title = title, description = description)
            )
        }
    }
}
