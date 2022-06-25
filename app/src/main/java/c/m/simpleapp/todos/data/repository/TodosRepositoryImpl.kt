package c.m.simpleapp.todos.data.repository

import c.m.simpleapp.R
import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.common.util.UIText
import c.m.simpleapp.todos.data.mapper.toTodo
import c.m.simpleapp.todos.data.mapper.toTodos
import c.m.simpleapp.todos.data.remote.TodosAPI
import c.m.simpleapp.todos.domain.model.Todo
import c.m.simpleapp.todos.domain.model.Todos
import c.m.simpleapp.todos.domain.repository.TodosRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

class TodosRepositoryImpl(private val todosAPI: TodosAPI) : TodosRepository {
    override suspend fun getTodos(): Flow<Resource<Todos>> {
        return flow {
            emit(Resource.Loading())

            try {
                val todosData = todosAPI.getTodos().toTodos()

                emit(Resource.Success(todosData))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_internet_problem))
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_internet_problem))
                )
            } catch (e: UnknownHostException) {
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_unknown))
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getTodo(todoId: Int): Flow<Resource<Todo>> {
        return flow {
            emit(Resource.Loading())

            try {
                val todoData = todosAPI.getTodo(todoId).toTodo()

                emit(Resource.Success(todoData))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_internet_problem))
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_internet_problem))
                )
            } catch (e: UnknownHostException) {
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_unknown))
                )
            }
        }
    }
}