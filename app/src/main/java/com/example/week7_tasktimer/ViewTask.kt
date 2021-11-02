package com.example.week7_tasktimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week7_tasktimer.models.TaskDatabase
import com.example.week7_tasktimer.models.Tasks

class ViewTask : AppCompatActivity() {
    lateinit var recyclerV:RecyclerView
    lateinit var taskList:List<Tasks>
    lateinit var myDBRoom:TaskDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_task)
        taskList= listOf()
        recyclerV=findViewById(R.id.rv)


        myDBRoom = TaskDatabase.getInstance(this)
        taskList= myDBRoom.Task_Dao().getAllTasks()

        recyclerV.adapter = RV_Adapter(this, taskList)
        recyclerV.layoutManager = LinearLayoutManager(this)


        recyclerV.scrollToPosition(taskList.size - 1)



    }
}