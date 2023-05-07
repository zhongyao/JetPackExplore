package com.hongri.jetpack.lifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.hongri.jetpack.R

/**
 * LifeCycle:
 * 通过观察者模式监听生命周期
 *
 * 优势:
 * 1、可感知生命周期，将生命周期的响应与 Activity 解耦
 * 2、容易测试（单元测试）
 * 3、可以避免在不正确的生命周期时进行回调
 */
class LifeCycleActivity : AppCompatActivity() {
    private val TAG = "LifeCycleActivity"
    private lateinit var currentStateBtn: Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        lifecycle.addObserver(MyObserver(lifecycle))

//        Util.checkUserStatus { result ->
//            if (result) {
//                myLocationListener.enable()
//            }
//        }

        currentStateBtn = findViewById(R.id.currentStateBtn)
        currentStateBtn.setOnClickListener {
            //使用lifecycle.currentState可主动获取当前Activity的生命周期状态
            Log.d(TAG, "当前Activity状态 -- " + lifecycle.currentState);
        }

    }
}