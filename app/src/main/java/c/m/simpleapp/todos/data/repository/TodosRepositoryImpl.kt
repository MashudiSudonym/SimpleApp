package c.m.simpleapp.todos.data.repository

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.todos.data.remote.TodosAPI
import c.m.simpleapp.todos.domain.model.Todo
import c.m.simpleapp.todos.domain.model.Todos
import c.m.simpleapp.todos.domain.repository.TodosRepository
import kotlinx.coroutines.flow.Flow

class TodosRepositoryImpl(private val todosAPI: TodosAPI) : TodosRepository {
    override suspend fun getTodos(): Flow<Resource<Todos>> {
        TODO("Not yet implemented")
    }

    override suspend fun getTodo(todoId: Int): Flow<Resource<Todo>> {
        TODO("Not yet implemented")
    }
}