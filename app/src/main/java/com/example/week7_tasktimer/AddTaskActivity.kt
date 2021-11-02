package com.example.week7_tasktimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.week7_tasktimer.models.TaskDatabase
import com.example.week7_tasktimer.models.Tasks

class AddTaskActivity : AppCompatActivity() {

    lateinit var edName: EditText
    lateinit var edDes: EditText
    lateinit var saveBtn: Button
    lateinit var viewBtn: Button

    lateinit var myDBRoom: TaskDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        edName = findViewById(R.id.name_ed)
        edDes = findViewById(R.id.des_ed)
        saveBtn = findViewById(R.id.buttonS)

        myDBRoom = TaskDatabase.getInstance(this)

        saveBtn.setOnClickListener {
            //save the user enters to the database

            var userEnterName = edName.text.toString()
            var userEnterDesc = edDes.text.toString()

            if (userEnterName.isNotEmpty() && userEnterDesc.isNotEmpty()) {

                myDBRoom.Task_Dao().insertTask(Tasks(0, userEnterName, userEnterDesc))
                Toast.makeText(this, "DataSave Successfuly!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Please Enter All  ", Toast.LENGTH_SHORT).show()

            }
        }
    }
}