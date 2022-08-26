package c.m.simpleapp.todo.presentation.state

import c.m.simpleapp.common.util.UIText
import c.m.simpleapp.todo.domain.model.Todo

data class ListTodoUIState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val todoItems: List<Todo> = emptyList(),
    val errorMessage: UIText? = null,
    val isRefresh: Boolean = false,
)