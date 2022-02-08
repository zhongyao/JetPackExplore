package com.hongri.jetpack.lifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.hongri.jetpack.R

class LifeCycleActivity : AppCompatActivity() {
    val TAG = "LifeCycleActivity"
    private lateinit var currentStateBtn: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        lifecycle.addObserver(MyObserver(lifecycle))

        currentStateBtn = findViewById(R.id.currentStateBtn)
        currentStateBtn.setOnClickListener {
            //使用lifecycle.currentState可主动获取当前Activity的生命周期状态
            Log.d(TAG, "当前Activity状态 -- " + lifecycle.currentState);
        }

    }
}