package com.example.project2_todolistapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

// 1. Entity -> Table Structure -> How your data is stored
@Entity(tableName = "notes_table")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val isMarkedDone: Boolean = false,

    val title: String,

    val desc: String,

    val date: Date,
)


// Integer
// Text
// Char
// Boolean -> Integer (0,1)

// To store a custom object - we need to convert that object into one of the accepted types of DB
