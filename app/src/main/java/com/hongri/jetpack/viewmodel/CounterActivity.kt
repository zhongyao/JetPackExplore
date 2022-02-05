package com.hongri.jetpack.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
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
            viewModel.counter++
            refreshCounter()
        }

        clearBtn.setOnClickListener {
            viewModel.counter = 0
            refreshCounter()
        }
        refreshCounter()
    }

    private fun refreshCounter() {
        infoText.text = viewModel.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit().putInt("count_reserved", viewModel.counter).apply()
    }
}