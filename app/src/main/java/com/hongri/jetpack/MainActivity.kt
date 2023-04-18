package com.hongri.jetpack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.hongri.jetpack.lifecycles.LifeCycleActivity
import com.hongri.jetpack.lifecycles.MyLifecycleService
import com.hongri.jetpack.room.RoomActivity
import com.hongri.jetpack.viewmodel_livedata.CounterActivity
import com.hongri.jetpack.workmanager.WorkManagerActivity

class MainActivity : AppCompatActivity() {
    private lateinit var viewModelBtn: Button
    private lateinit var liveDataBtn: Button
    private lateinit var lifeCycleBtn: Button
    private lateinit var roomBtn: Button
    private lateinit var workManagerBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelBtn = findViewById(R.id.viewModelBtn)
        liveDataBtn = findViewById(R.id.liveDataBtn)
        lifeCycleBtn = findViewById(R.id.lifeCycleBtn)
        roomBtn = findViewById(R.id.roomBtn)
        workManagerBtn = findViewById(R.id.workManagerBtn)

        viewModelBtn.setOnClickListener {
            val intent = Intent(this, CounterActivity::class.java)
            startActivity(intent)
        }

        lifeCycleBtn.setOnClickListener {
            //启动Activity
            val intent = Intent(this, LifeCycleActivity::class.java)
            startActivity(intent)

            //启动Service
//            val intent = Intent(this, MyLifecycleService::class.java)
//            startService(intent)
        }

        roomBtn.setOnClickListener {
            val intent = Intent(this, RoomActivity::class.java)
            startActivity(intent)
        }

        workManagerBtn.setOnClickListener {
            val intent = Intent(this, WorkManagerActivity::class.java)
            startActivity(intent)
        }
    }
}