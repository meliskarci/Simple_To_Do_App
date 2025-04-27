package com.meliskarci.simpletodoapp.presentation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meliskarci.simpletodoapp.data.local.TodoEntity
import com.meliskarci.simpletodoapp.domain.repository.ToDoDaoRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val repository: ToDoDaoRepositoryImpl
) : ViewModel() {

    fun insertTodo(todo: TodoEntity) {
        viewModelScope.launch {
            repository.insertTodo(todo)
        }
    }
}