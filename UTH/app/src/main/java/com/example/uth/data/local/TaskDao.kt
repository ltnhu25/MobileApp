package com.example.uth.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {

    @Insert
    suspend fun insert(task: TaskEntity)

    @Query("SELECT * FROM tasks ORDER BY id DESC")
    fun getAllTasks(): LiveData<List<TaskEntity>>
}
