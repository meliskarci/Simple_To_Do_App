package com.meliskarci.simpletodoapp.domain.repository

import com.meliskarci.simpletodoapp.data.local.TodoDao
import com.meliskarci.simpletodoapp.data.local.TodoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ToDoDaoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
) {
    suspend fun insertTodo(todo: TodoEntity) {
        todoDao.insertTodo(todo)
    }

    fun getTodos(): Flow<List<TodoEntity>> = flow {
        todoDao.getTodos().collect {
            emit(it)
        }
    }

    suspend fun deleteTodo(id: Int) {
        todoDao.deleteTodo(id)
    }

    fun getTodoById(id: Int): Flow<TodoEntity> = flow {
        todoDao.getTodoById(id).collect {
            emit(it)
        }
    }

    suspend fun updateTodo(id: Int, title: String, description: String) {
        todoDao.updateTodo(id, title, description)
    }


}