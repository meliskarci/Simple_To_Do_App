package com.meliskarci.simpletodoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.meliskarci.simpletodoapp.data.local.TodoEntity
import com.meliskarci.simpletodoapp.domain.repository.ToDoDaoRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: ToDoDaoRepositoryImpl
) : ViewModel() {

    private val _list = MutableStateFlow<List<TodoEntity>>(emptyList())
    val list : StateFlow<List<TodoEntity>>
        get() = _list.asStateFlow()


    init {
        getAllTodos()
    }


    fun getAllTodos(){
        viewModelScope.launch {
            repository.getTodos().collect{ todoList ->
                _list.value = todoList
            }
        }
    }
}

//usecase doldurduktan sonra getalltodosusecase çağır repository yerine