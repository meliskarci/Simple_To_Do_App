package com.meliskarci.simpletodoapp.domain.usecase

import com.meliskarci.simpletodoapp.data.local.TodoEntity
import com.meliskarci.simpletodoapp.domain.repository.ToDoDaoRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class getTodosUseCase @Inject constructor(
    private val repository: ToDoDaoRepositoryImpl
) {
    operator fun invoke() : Flow<List<TodoEntity>> {
        return repository.getTodos()
    }
}