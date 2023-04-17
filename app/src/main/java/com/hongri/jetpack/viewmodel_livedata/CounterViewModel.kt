package com.hongri.jetpack.viewmodel_livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel(countReserved: Int) : ViewModel() {

    /**
     * reference：https://cloud.tencent.com/developer/article/1763734
     *
     * LiveData就是一个数据容器，它负责将数据包裹起来，使数据成为被观察者，
     * 当数据发生变化时，LiveData会通知观察者，以便观察者作出响应。
     *
     * LiveData具有如下优势：
     * 1、LiveData是一个持有数据的容器类，它持有的数据是可以被观察者订阅的，当数据发生变化时会通知观察者，观察者可以是 Activity、Fragment、Service 等对象。
     * 2、LiveData 具有感知观察者的生命周期能力，并且只有当观察者处于激活状态（STARTED、RESUMED）才会接收到数据更新的通知，在未激活时会自动解除注册观察者，以降低内存泄漏的风险。
     * 3、使用 LiveData 保存数据时，由于数据和组件是分离的，所以当组件被销毁时可以保证数据不会丢失。
     *
     */
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