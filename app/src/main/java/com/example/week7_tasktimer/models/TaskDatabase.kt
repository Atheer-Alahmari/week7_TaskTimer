package com.example.week7_tasktimer.models

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Tasks::class],version = 1 ,exportSchema = false)
abstract class TaskDatabase: RoomDatabase() {

    companion object{


        var instance: TaskDatabase?=null
        fun getInstance(ctx: Context): TaskDatabase
        {
            if(instance!=null)
            {
                return  instance as TaskDatabase
            }
            instance= Room.databaseBuilder(ctx,TaskDatabase::class.java,"somename2").run { allowMainThreadQueries() }.build();
            return instance as TaskDatabase
        }
    }
    abstract fun Task_Dao():TaskDao
}