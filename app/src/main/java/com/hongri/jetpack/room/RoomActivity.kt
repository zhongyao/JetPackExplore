package com.hongri.jetpack.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.hongri.jetpack.R
import kotlin.concurrent.thread

/**
 * Jetpack 之 Room 示例
 */
class RoomActivity : AppCompatActivity() {
    private val TAG = "RoomActivity";
    private lateinit var getUserBtn: Button
    private lateinit var addDataBtn: Button
    private lateinit var updateDataBtn: Button
    private lateinit var deleteDataBtn: Button
    private lateinit var queryDataBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        getUserBtn = findViewById(R.id.queryDataBtn)
        addDataBtn = findViewById(R.id.addDataBtn)
        updateDataBtn = findViewById(R.id.updateDataBtn)
        deleteDataBtn = findViewById(R.id.deleteDataBtn)
        queryDataBtn = findViewById(R.id.queryDataBtn)

        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("zhong", "yao", 18)
        val user2 = User("cheng", "long", 60)

        addDataBtn.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }

        updateDataBtn.setOnClickListener {
            thread {
                user1.age = 20
                userDao.updateUser(user1)
            }
        }

        deleteDataBtn.setOnClickListener {
            thread {
                userDao.deleteUserByLastName("long")
            }
        }

        queryDataBtn.setOnClickListener {
            thread {
                for (user in userDao.loadAllUsers()) {
                    Log.d(TAG, user.toString())
                }
            }
        }
    }
}