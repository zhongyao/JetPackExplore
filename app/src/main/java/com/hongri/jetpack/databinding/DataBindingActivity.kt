package com.hongri.jetpack.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hongri.jetpack.R

/**
 * 实现双向绑定，数据和UI同步
 */
class DataBindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_binding)
    }
}