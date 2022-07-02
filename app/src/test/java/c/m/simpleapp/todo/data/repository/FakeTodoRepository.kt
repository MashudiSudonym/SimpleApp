package c.m.simpleapp.todo.data.repository

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.dummy.todo.FakeDummyTodoData
import c.m.simpleapp.todo.domain.model.Todo
import c.m.simpleapp.todo.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeTodoRepository : TodoRepository {
    private val fakeListTodoData = FakeDummyTodoData().fakeListTodo()
    private val fakeDetailTodoData = FakeDummyTodoData().fakeTodo()

    override suspend fun getListTodo(): Flow<Resource<List<Todo>>> {
        return flow {
            emit(Resource.Loading())

            emit(Resource.Success(fakeListTodoData))
        }
    }

    override suspend fun getTodo(todoId: Int): Flow<Resource<Todo>> {
        return flow {
            emit(Resource.Loading())

            emit(Resource.Success(fakeDetailTodoData))
        }
    }
}