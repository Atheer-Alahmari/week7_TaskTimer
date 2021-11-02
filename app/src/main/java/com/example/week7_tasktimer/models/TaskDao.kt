package com.example.week7_tasktimer.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface TaskDao {
    @Query("SELECT * FROM Task  ORDER BY Name ASC")
    fun getAllTasks(): List<Tasks>

    @Insert
    fun insertTask(input: Tasks)
}