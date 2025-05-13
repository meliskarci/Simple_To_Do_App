package com.meliskarci.simpletodoapp.domain.usecase

import com.meliskarci.simpletodoapp.data.local.TodoEntity
import com.meliskarci.simpletodoapp.domain.repository.ToDoDaoRepositoryImpl
import javax.inject.Inject

class InsertTodoUsecase @Inject constructor(
    private val repository: ToDoDaoRepositoryImpl
) {
    suspend operator fun invoke(todo: TodoEntity) {
        repository.insertTodo(todo)

    }
}