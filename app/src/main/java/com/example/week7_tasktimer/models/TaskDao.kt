package com.example.week7_tasktimer.models

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface TaskDao {
    @Query("SELECT * FROM Task ORDER BY id  ")
    fun getAllTasks(): List<Tasks>

    @Insert
    fun insertTask(input: Tasks)
    @Update
    fun updateTimeTask(input: Tasks)
}