package com.meliskarci.simpletodoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TodoEntity::class], version = 2)
abstract class ToDoDatabase: RoomDatabase()  {
    abstract fun todoDao(): TodoDao
}