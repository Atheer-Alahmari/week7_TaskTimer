package com.example.week7_tasktimer.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class Tasks (
    @PrimaryKey(autoGenerate = true)@ColumnInfo(name="id")val id:Int=0,
    @ColumnInfo(name="Name")val name:String="",
    @ColumnInfo(name="Description")val description:String="",
    @ColumnInfo(name="PauseOff")val PauseOff:Long=0 ,
    @ColumnInfo(name="Time")var time:String=""

)