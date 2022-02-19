package com.hongri.jetpack.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 声明实体类
 */
@Entity
data class User(var firstName: String, var lastName: String, var age: Int) {

    /**
     * 设置主键，并使得主键的值自动生成
     */
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}