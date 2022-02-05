package com.hongri.jetpack.viewmodel

import androidx.lifecycle.ViewModel

class CounterViewModel(countReserved: Int) : ViewModel() {
    var counter = countReserved
}