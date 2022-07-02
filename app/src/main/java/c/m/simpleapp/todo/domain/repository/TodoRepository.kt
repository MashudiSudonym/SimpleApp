package c.m.simpleapp.todo.domain.repository

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.todo.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    suspend fun getListTodo(): Flow<Resource<List<Todo>>>
    suspend fun getTodo(todoId: Int): Flow<Resource<Todo>>
}