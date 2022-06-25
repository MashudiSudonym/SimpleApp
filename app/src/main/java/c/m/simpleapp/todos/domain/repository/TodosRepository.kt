package c.m.simpleapp.todos.domain.repository

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.todos.domain.model.Todo
import c.m.simpleapp.todos.domain.model.Todos
import kotlinx.coroutines.flow.Flow

interface TodosRepository {
    suspend fun getTodos(): Flow<Resource<Todos>>
    suspend fun getTodo(todoId: Int): Flow<Resource<Todo>>
}