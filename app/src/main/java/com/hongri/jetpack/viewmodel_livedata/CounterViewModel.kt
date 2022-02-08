package com.hongri.jetpack.viewmodel_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel(countReserved: Int) : ViewModel() {

    val counter: LiveData<Int> get() = _counter
    /**
     * LiveData【响应式编程组件】：可以包含任何类型的数据，并在数据发生变化的时候通知给观察者
     */
    private val _counter = MutableLiveData<Int>()

    init {
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = _counter.value ?: 0
        _counter.value = count + 1
    }

    fun clear() {
        _counter.value = 0
    }
}