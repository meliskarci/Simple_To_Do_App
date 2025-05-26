package com.meliskarci.simpletodoapp.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Todos")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int = 0,
    @ColumnInfo(name = "title")
    val title : String,
    @ColumnInfo(name = "description")
    val description : String,
    @ColumnInfo(name = "isCompleted")
    val isCompleted : Boolean = false,
    @ColumnInfo(name = "dueDate")
    val dueDate: Long? = null

)

