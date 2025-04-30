package com.meliskarci.simpletodoapp.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meliskarci.simpletodoapp.data.local.TodoEntity
import com.meliskarci.simpletodoapp.domain.repository.ToDoDaoRepositoryImpl
import com.meliskarci.simpletodoapp.domain.repository.usecase.GetTodoByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getTodoByIdUseCase: GetTodoByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val id = savedStateHandle.get<Int>("id") ?: 0

    private val _todo = MutableStateFlow<TodoEntity>(TodoEntity(title = "Boş veri", description = "Boş veri"))
    val todo: MutableStateFlow<TodoEntity>
        get() = _todo

    init {
        getById(id)
    }

    private fun getById(id: Int) {
        viewModelScope.launch {
            getTodoByIdUseCase.invoke(id).collect {
                _todo.value = it
            }
            }
    }
}