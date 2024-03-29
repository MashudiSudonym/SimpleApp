package c.m.simpleapp.todo.presentation.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.todo.domain.use_case.get_list_todo_use_case.GetListTodoUseCase
import c.m.simpleapp.todo.presentation.event.TodoUIStatusEvent
import c.m.simpleapp.todo.presentation.state.ListTodoUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val getListTodoUseCase: GetListTodoUseCase,
) : ViewModel() {
    private val _listTodoUIState = MutableStateFlow(ListTodoUIState())
    val listTodoUIState: StateFlow<ListTodoUIState> = _listTodoUIState.asStateFlow()

    private val todoUIStatusEventChannel = Channel<TodoUIStatusEvent>()
    val todoUIStatusEvent = todoUIStatusEventChannel.receiveAsFlow()

    init {
        getListTodo()
    }

    fun getListTodoFromSwipeRefresh() {
        getListTodo()
    }

    private fun getListTodo() {
        viewModelScope.launch {
            getListTodoUseCase().collect { result ->
                when (result) {
                    is Resource.Error -> {
                        _listTodoUIState.update {
                            it.copy(
                                isLoading = false,
                                isError = true,
                                todoItems = result.data ?: emptyList(),
                                errorMessage = result.message,
                                isRefresh = false
                            )
                        }
                        todoUIStatusEventChannel.send(TodoUIStatusEvent.Error)
                    }
                    is Resource.Loading -> _listTodoUIState.update {
                        it.copy(
                            isLoading = true,
                            isError = false,
                            todoItems = result.data ?: emptyList(),
                            isRefresh = true
                        )
                    }
                    is Resource.Success -> _listTodoUIState.update {
                        it.copy(
                            isLoading = false,
                            isError = false,
                            todoItems = result.data ?: emptyList(),
                            isRefresh = false
                        )
                    }
                }
            }
        }
    }
}