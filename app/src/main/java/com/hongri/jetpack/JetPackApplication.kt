package com.hongri.jetpack

import android.app.Application
import android.content.Context
import androidx.lifecycle.ProcessLifecycleOwner
import com.hongri.jetpack.lifecycles.MyObserver

/**
 * 自定义Application类：
 * 获取Application的Context可以直接通过 JetPackApplication.context获取。
 */
class JetPackApplication : Application() {

    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext

        //为整个应用的Activity组件添加监听【第一个Activity打开的时候，会调用onStart等,最后一个Activity退出的时候回调用onPause等】
        ProcessLifecycleOwner.get().lifecycle.addObserver(MyObserver(null))
    }
}