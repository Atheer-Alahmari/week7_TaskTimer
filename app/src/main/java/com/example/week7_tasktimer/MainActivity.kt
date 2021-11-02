package com.example.week7_tasktimer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import java.net.InterfaceAddress

class MainActivity : AppCompatActivity() {

    lateinit var addBtn:Button
    lateinit var viewBtn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBtn = findViewById(R.id.button)
        addBtn.setOnClickListener {
            val intent = Intent(this,AddTaskActivity::class.java)
            startActivity(intent)
        }

    }
}