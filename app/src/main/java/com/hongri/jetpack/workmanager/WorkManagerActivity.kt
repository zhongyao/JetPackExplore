package com.hongri.jetpack.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.observe
import androidx.work.BackoffPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import com.hongri.jetpack.R
import java.util.concurrent.TimeUnit

/**
 * WorkManager基本用法：
 * 1、定义一个后台任务，并实现具体的任务逻辑
 * 2、配置该后台任务的运行条件跟约束信息，并构建后台任务请求
 * 3、将该后台任务请求传入WorkManager的enqueue()方法中，系统会在合适的时间运行
 */
class WorkManagerActivity : AppCompatActivity() {
    private val TAG = "WorkManagerActivity"
    private lateinit var doWorkManagerBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_work_manager)

        doWorkManagerBtn = findViewById(R.id.doWorkManagerBtn)

        doWorkManagerBtn.setOnClickListener {
            //构建简单任务
//            val request = OneTimeWorkRequest.Builder(SimpleWorker::class.java).build()

            //构建复制任务【延迟时间 + 设置标签 + 失败后重新执行任务】
            val request = OneTimeWorkRequest.Builder(SimpleWorker::class.java).setInitialDelay(5, TimeUnit.SECONDS).addTag("Simple").setBackoffCriteria(BackoffPolicy.LINEAR, 10, TimeUnit.SECONDS).build()
            WorkManager.getInstance(this).enqueue(request)

            //监听后台任务的执行结果
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id).observe(this) { workInfo ->
                if (workInfo.state == WorkInfo.State.SUCCEEDED) {
                    Log.d(TAG, "do work success")
                } else if (workInfo.state == WorkInfo.State.FAILED) {
                    Log.d(TAG, "do work failed")
                }
            }

            //支持链式任务
//            WorkManager.getInstance(this).beginWith(request1).then(request2).then(request3).enqueue();
        }
    }
}