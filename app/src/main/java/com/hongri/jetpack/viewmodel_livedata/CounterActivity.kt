package com.hongri.jetpack.viewmodel_livedata

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hongri.jetpack.R

class CounterActivity : AppCompatActivity() {
    lateinit var viewModel: CounterViewModel
    lateinit var sp: SharedPreferences
    private lateinit var infoText: TextView
    private lateinit var plusBtn: Button
    private lateinit var clearBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("count_reserved", 0)
        viewModel = ViewModelProviders.of(this, CounterViewModelFactory(countReserved)).get(CounterViewModel::class.java)

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
        sp.edit().putInt("count_reserved", viewModel.counter.value ?: 0).apply()
    }
}