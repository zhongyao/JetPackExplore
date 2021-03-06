package com.hongri.jetpack.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * 定义Database，写法是固定的，只需要定义3个部分的内容：
 * 1、数据库的版本号
 * 2、包含哪些实体类
 * 3、提供Dao层的访问实例
 */
@Database(version = 3, entities = [User::class, Book::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun bookDao(): BookDao

    companion object {

        //数据库升级 1-2:添加一个Book表
        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("create table Book(id integer primary key autoincrement not null, name text not null, pages integer not null)")
            }
        }

        //数据库升级 2-3:Book表中添加一个字段author
        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("alter table Book add column author text not null default 'unknown'")
            }
        }

        private var instance: AppDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): AppDatabase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "app_database")
                    //数据库升级
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                    .build().apply {
                        instance = this
                    }
        }
    }
}