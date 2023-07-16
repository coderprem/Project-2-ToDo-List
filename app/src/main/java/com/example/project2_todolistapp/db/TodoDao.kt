package com.example.project2_todolistapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

// DAO -> Data Access Object -> This helps you in accessing the db without a lot of code

@Dao
interface TodoDao {
    // CRUD -> Create | Read | Update | Delete

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTodo(todo: Todo)

    @Query("select * from notes_table")
    fun fetchAllTodos(): MutableList<Todo>

    @Query(
        "select * from notes_table where notes_table.`desc` like :searchQuery or notes_table.title like :searchQuery"
    )
    fun fetchSearchedTodos(searchQuery: String): MutableList<Todo>

    @Query(
        "select * from notes_table where notes_table.date >:timestamp"
    )
    fun fetchTodosForDate(timestamp: Long): MutableList<Todo>

    @Query("DELETE FROM Notes_table")
    fun deleteAll()
}