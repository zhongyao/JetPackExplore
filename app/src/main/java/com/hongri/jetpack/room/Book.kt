package com.hongri.jetpack.room

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 声明实体类
 */
@Entity
data class Book(var name: String, var pages: Int, var author: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}