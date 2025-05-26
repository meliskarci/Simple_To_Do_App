package com.meliskarci.simpletodoapp.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meliskarci.simpletodoapp.data.local.TodoEntity
import com.meliskarci.simpletodoapp.domain.usecase.DeleteTodoUsecase
import com.meliskarci.simpletodoapp.domain.usecase.GetTodoByIdUseCase
import com.meliskarci.simpletodoapp.domain.usecase.UpdateTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getTodoByIdUseCase: GetTodoByIdUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val deleteTodoUseCase: DeleteTodoUsecase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val id = savedStateHandle.get<Int>("id") ?: 0

    private val _todo = MutableStateFlow<TodoEntity>(TodoEntity(title = "Boş veri", description = "Boş veri"))
    val todo: StateFlow<TodoEntity>
        get() = _todo.asStateFlow()

    init {
        getById(id)
    }

    private fun getById(id: Int) {
        viewModelScope.launch {
            getTodoByIdUseCase(id).collect {
                _todo.value = it
            }
        }
    }

    fun updateTaskStatus(id: Int, isCompleted: Boolean) {
        viewModelScope.launch {
            _todo.value = _todo.value.copy(isCompleted = isCompleted)

            updateTodoUseCase(
                id = _todo.value.id,
                title = _todo.value.title,
                description = _todo.value.description,
                dueDate = _todo.value.dueDate,
                isCompleted = isCompleted
            )
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch {
            deleteTodoUseCase(id)
        }
    }
}