package com.example.week7_tasktimer

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import android.widget.Chronometer.OnChronometerTickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.week7_tasktimer.models.TaskDatabase
import com.example.week7_tasktimer.models.Tasks
import kotlinx.android.synthetic.main.activity_task_timer.*


class TaskTimer : AppCompatActivity() {
   lateinit  var chronometer: Chronometer
    private var pauseOffset: Long = 0
    private var running = false
lateinit var myDBRoom:TaskDatabase
lateinit var taskList:List<Tasks>

  var taskID:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_timer)
        taskList= listOf()

         taskID = (intent.extras?.getInt("TaskId")!!)-1
        println("taskID  $taskID")

//        var taskName= intent.getStringExtra("TaskName")
//       var taskDescription=intent.getStringExtra("TaskDescription")
        myDBRoom = TaskDatabase.getInstance(this)
         taskList=myDBRoom.Task_Dao().getAllTasks()

        var taskName=taskList[taskID].name
        var taskDescription=taskList[taskID].description

        nameTV.text=taskName
        desTV.text=taskDescription

        chronometer = findViewById(R.id.chronometer)


        chronometer.setFormat("Time: %s")
        chronometer.setBase(SystemClock.elapsedRealtime())
        chronometer.setOnChronometerTickListener(OnChronometerTickListener { chronometer ->
            if (SystemClock.elapsedRealtime() - chronometer.base >= 10000000) {
                chronometer.base = SystemClock.elapsedRealtime()
                Toast.makeText(this, "Bing!", Toast.LENGTH_SHORT).show()
            }
        })
    }

    fun startChronometer(v: View?) {
        if (!running) {
            chronometer!!.base = SystemClock.elapsedRealtime() - pauseOffset
            chronometer!!.start()
            running = true
        }
    }

    fun pauseChronometer(v: View?) {
        if (running) {

            chronometer!!.stop()
            pauseOffset = SystemClock.elapsedRealtime() - chronometer!!.base // ------------pauseOffset:Long
            running = false
            var time=chronometer!!.text.toString().subSequence(5,11)//------------------time:String
            showTimer.text= time
            myDBRoom = TaskDatabase.getInstance(this)
            taskList=myDBRoom.Task_Dao().getAllTasks()

            taskList[taskID].time =time.toString()

            var taskName=taskList[taskID].name
            var taskDescription=taskList[taskID].description
            var taskTime= taskList[taskID].time

            myDBRoom.Task_Dao().updateTimeTask(Tasks(taskID, taskName,taskDescription,pauseOffset,taskTime))

//            println("taskTime  $taskTime")
//            taskList[taskID].time =time.toString()
//            println("taskTime2  ${taskList[taskID].time}")

        }
    }

    fun resetChronometer(v: View?) {
        chronometer!!.base = SystemClock.elapsedRealtime()
        pauseOffset = 0
    }





//    fun stopIcon(view: android.view.View) {}
//    fun startIcon(view: android.view.View) {}
}