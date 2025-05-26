package com.meliskarci.simpletodoapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meliskarci.simpletodoapp.data.local.TodoEntity
import com.meliskarci.simpletodoapp.domain.usecase.getTodosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.meliskarci.simpletodoapp.domain.usecase.DeleteTodoUsecase
import com.meliskarci.simpletodoapp.domain.usecase.UpdateTodoUseCase

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getTodosUseCase: getTodosUseCase,
    private val deleteTodoUsecase: DeleteTodoUsecase,
    private val updateTodoUseCase: UpdateTodoUseCase
) : ViewModel() {

    private val _list = MutableStateFlow<List<TodoEntity>>(emptyList())
    val list : StateFlow<List<TodoEntity>>
        get() = _list.asStateFlow()


    init {
        getAllTodos()
    }

    private fun getAllTodos() {
        viewModelScope.launch {
            getTodosUseCase.invoke().collect { todoList ->
                _list.value = todoList
            }
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch {
            deleteTodoUsecase(id)
        }
    }

    fun updateTodo(id: Int, title: String, description: String, dueDate: Long, isCompleted: Boolean) {
        viewModelScope.launch {
            updateTodoUseCase(id, title, description, dueDate, isCompleted )
        }
    }


}
