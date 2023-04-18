package com.hongri.jetpack.lifecycles

import androidx.lifecycle.LifecycleService

class MyLifecycleService : LifecycleService {

    constructor() {
        var myObserver = MyObserver(lifecycle)
        lifecycle.addObserver(myObserver)
    }
}