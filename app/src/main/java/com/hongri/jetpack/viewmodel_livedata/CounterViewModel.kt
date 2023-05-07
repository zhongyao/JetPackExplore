package com.hongri.jetpack.viewmodel_livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * ViewModel:
 * 以注重生命周期的方式存储和管理界面相关数据。
 * 优势：
 * 1、不受activity生命周期影响，在发生屏幕旋转等配置更改后ViewModel可让数据继续留存。
 * 2、Activity 和 Fragment界面控制器经常需要进行可能需要一些时间才能返回的异步调用。界面控制器需要管理这些调用，并确保系统在其销毁后清理这些调用以避免潜在的内存泄漏
 * 3、使用ViewModel从界面控制器(Activity、Fragment)逻辑中分离出视图数据所有权的操作更容易且更高效。
 */
class CounterViewModel : ViewModel() {

    /**
     * reference：https://cloud.tencent.com/developer/article/1763734
     *
     * LiveData【响应式编程组件】就是一个数据容器，它负责将数据包裹起来，使数据成为被观察者，
     * 当数据发生变化时，LiveData会通知观察者，以便观察者作出响应。
     *
     * LiveData具有如下优势：
     * 1、LiveData是一个持有数据的容器类，它持有的数据是可以被观察者订阅的，当数据发生变化时会通知观察者，观察者可以是 Activity、Fragment、Service 等对象。
     * 2、LiveData 具有感知观察者的生命周期能力，并且只有当观察者处于激活状态（STARTED、RESUMED）才会接收到数据更新的通知，在未激活时会自动解除注册观察者，以降低内存泄漏的风险。
     * 3、使用 LiveData 保存数据时，由于数据和组件是分离的，所以当组件被销毁时可以保证数据不会丢失。
     *
     */
    val counter: MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    }

    fun plusOne() {
        val count = counter.value ?: 0
        counter.value = count + 1
    }

    fun clear() {
        counter.value = 0
    }

    /**
     * 移除监听器等
     */
    override fun onCleared() {
        super.onCleared()
    }
}