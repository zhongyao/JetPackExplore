package com.hongri.jetpack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.hongri.jetpack.lifecycles.LifeCycleActivity
import com.hongri.jetpack.room.RoomActivity
import com.hongri.jetpack.viewmodel_livedata.CounterActivity

class MainActivity : AppCompatActivity() {
    private lateinit var viewModelBtn: Button
    private lateinit var liveDataBtn: Button
    private lateinit var lifeCycleBtn: Button
    private lateinit var roomBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelBtn = findViewById(R.id.viewModelBtn)
        liveDataBtn = findViewById(R.id.liveDataBtn)
        lifeCycleBtn = findViewById(R.id.lifeCycleBtn)
        roomBtn = findViewById(R.id.roomBtn)

        viewModelBtn.setOnClickListener {
            val intent = Intent(this, CounterActivity::class.java)
            startActivity(intent)
        }

        lifeCycleBtn.setOnClickListener {
            val intent = Intent(this, LifeCycleActivity::class.java)
            startActivity(intent)
        }

        roomBtn.setOnClickListener {
            val intent = Intent(this, RoomActivity::class.java)
            startActivity(intent)
        }
    }
}