package com.hongri.jetpack.lifecycles

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

private const val TAG = "MyObserver"
class MyObserver(private val lifecycle: Lifecycle?) : LifecycleObserver {

    private var enabled = false
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun create() {
        Log.d(TAG, "create")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart() {
        Log.d(TAG, "activityStart")
        if (enabled) {
            // connect
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun activityPause() {
        Log.d(TAG, "当前Activity的状态:" + lifecycle?.currentState)
        Log.d(TAG, "activityPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop() {
        Log.d(TAG, "activityStop")
        // disconnect if connected
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun destroy() {
        Log.d(TAG, "destroy")
    }

    fun enable() {
        enabled = true
        if (lifecycle!!.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            // connect if not connected
        }
    }

}