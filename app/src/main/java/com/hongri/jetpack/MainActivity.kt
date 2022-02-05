package com.hongri.jetpack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.hongri.jetpack.viewmodel.CounterActivity

class MainActivity : AppCompatActivity() {
    private lateinit var viewModelBtn: Button
    private lateinit var liveDataBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModelBtn = findViewById(R.id.viewModelBtn)
        liveDataBtn = findViewById(R.id.liveDataBtn)

        viewModelBtn.setOnClickListener {
            var intent = Intent(this, CounterActivity::class.java)
            startActivity(intent)
        }
    }
}