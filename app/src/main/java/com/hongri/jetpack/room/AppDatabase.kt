package com.hongri.jetpack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * 定义Database，写法是固定的，只需要定义3个部分的内容：
 * 1、数据库的版本号
 * 2、包含哪些实体类
 * 3、提供Dao层的访问实例
 */
@Database(version = 1, entities = [User::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var instance: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app_database")
                    .build().apply {
                        instance = this
                    }
        }
    }
}