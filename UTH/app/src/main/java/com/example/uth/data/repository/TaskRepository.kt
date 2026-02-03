package com.example.uth.data.repository

import com.example.uth.data.local.TaskDao
import com.example.uth.data.local.TaskEntity

class TaskRepository(private val taskDao: TaskDao) {

    fun getAllTasks() = taskDao.getAllTasks()

    suspend fun insert(task: TaskEntity) {
        taskDao.insert(task)
    }
}
