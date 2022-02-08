package com.hongri.jetpack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.hongri.jetpack.lifecycles.LifeCycleActivity
import com.hongri.jetpack.viewmodel_livedata.CounterActivity

class MainActivity : AppCompatActivity() {
    private lateinit var viewModelBtn: Button
    private lateinit var liveDataBtn: Button
    private lateinit var lifeCycleBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelBtn = findViewById(R.id.viewModelBtn)
        liveDataBtn = findViewById(R.id.liveDataBtn)
        lifeCycleBtn = findViewById(R.id.lifeCycleBtn)

        viewModelBtn.setOnClickListener {
            var intent = Intent(this, CounterActivity::class.java)
            startActivity(intent)
        }

        lifeCycleBtn.setOnClickListener {
            var intent = Intent(this, LifeCycleActivity::class.java)
            startActivity(intent)
        }
    }
}