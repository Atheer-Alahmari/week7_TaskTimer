package com.example.week7_tasktimer

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Chronometer
import android.widget.Chronometer.OnChronometerTickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_task_timer.*


class TaskTimer : AppCompatActivity() {
   lateinit  var chronometer: Chronometer
    private var pauseOffset: Long = 0
    private var running = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_timer)


        chronometer = findViewById(R.id.chronometer)
        /*

        chronometer.onChronometerTickListener =
            OnChronometerTickListener { chronometer ->
                val time = SystemClock.elapsedRealtime() - chronometer.base
                val h = (time / 3600000).toInt()
                val m = (time - h * 3600000).toInt() / 60000
                val s = (time - h * 3600000 - m * 60000).toInt() / 1000
                val t =
                    (if (h < 10) "0$h" else h).toString() + ":" + (if (m < 10) "0$m" else m) + ":" + if (s < 10) "0$s" else s
                chronometer.text = t
            }
        chronometer.base = SystemClock.elapsedRealtime()
        chronometer.text = "00:00:00"


         */
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


        }
    }

    fun resetChronometer(v: View?) {
        chronometer!!.base = SystemClock.elapsedRealtime()
        pauseOffset = 0
    }





//    fun stopIcon(view: android.view.View) {}
//    fun startIcon(view: android.view.View) {}
}