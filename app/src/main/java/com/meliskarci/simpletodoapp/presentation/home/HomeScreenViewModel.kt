package com.meliskarci.simpletodoapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meliskarci.simpletodoapp.data.local.TodoEntity
import com.meliskarci.simpletodoapp.domain.repository.usecase.getTodosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.meliskarci.simpletodoapp.domain.repository.usecase.DeleteTodoUsecase

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getTodosUseCase: getTodosUseCase,
    private val deleteTodoUsecase: DeleteTodoUsecase
) : ViewModel() {

    private val _list = MutableStateFlow<List<TodoEntity>>(emptyList())
    val list : StateFlow<List<TodoEntity>>
        get() = _list.asStateFlow()


    init {
        getAllTodos()
    }

    fun getAllTodos() {
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


}

//usecase doldurduktan sonra getalltodosusecase çağır repository yerine