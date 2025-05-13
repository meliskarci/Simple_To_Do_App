package com.meliskarci.simpletodoapp.presentation.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meliskarci.simpletodoapp.data.local.TodoEntity
import com.meliskarci.simpletodoapp.domain.repository.ToDoDaoRepositoryImpl
import com.meliskarci.simpletodoapp.domain.usecase.InsertTodoUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val insertTodoUsecase: InsertTodoUsecase
) : ViewModel() {

    fun insertTodo(todo: TodoEntity) {
        viewModelScope.launch {
            insertTodoUsecase(todo)
        }
    }
}