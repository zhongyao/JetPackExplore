package com.hongri.jetpack

import android.app.Application
import android.content.Context

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
    }
}