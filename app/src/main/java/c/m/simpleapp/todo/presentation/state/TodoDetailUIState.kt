package c.m.simpleapp.todo.presentation.state

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.common.util.UIText
import c.m.simpleapp.todo.domain.model.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class TodoDetailUIState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: UIText? = null,
    val todoItem: Flow<Resource<Todo>> = emptyFlow(),
)
