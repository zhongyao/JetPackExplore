package com.hongri.jetpack.viewmodel_livedata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hongri.jetpack.R

class CounterActivity : AppCompatActivity() {
    private lateinit var viewModel: CounterViewModel
    private lateinit var sp: SharedPreferences
    private lateinit var infoText: TextView
    private lateinit var plusBtn: Button
    private lateinit var clearBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(CounterViewModel::class.java)
        //保证退出App再进入后，依然可展示上一次的值
        viewModel.counter.value = countReserved

        infoText = findViewById(R.id.infoText)
        plusBtn = findViewById(R.id.plusBtn)
        clearBtn = findViewById(R.id.clearBtn)

        plusBtn.setOnClickListener {
            viewModel.plusOne()
        }

        clearBtn.setOnClickListener {
            viewModel.clear()
        }

        /**
         * 关键：这里调用了ViewModel.counter的observe()方法来观察数据的变化
         * 【其counter变量现在已是一个LiveData对象】
         */
        viewModel.counter.observe(this, Observer { count ->
            infoText.text = count.toString()
        })
    }

    override fun onPause() {
        super.onPause()
        //缓冲值
        sp.edit().putInt("count_reserved", viewModel.counter.value ?: 0).apply()
    }
}