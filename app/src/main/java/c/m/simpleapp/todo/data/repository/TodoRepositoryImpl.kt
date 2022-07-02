package c.m.simpleapp.todo.data.repository

import c.m.simpleapp.R
import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.common.util.UIText
import c.m.simpleapp.todo.data.mapper.toTodo
import c.m.simpleapp.todo.data.remote.TodoAPI
import c.m.simpleapp.todo.domain.model.Todo
import c.m.simpleapp.todo.domain.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import java.net.UnknownHostException

class TodoRepositoryImpl(private val todoAPI: TodoAPI) : TodoRepository {
    override suspend fun getListTodo(): Flow<Resource<List<Todo>>> {
        return flow {
            emit(Resource.Loading())

            try {
                val todosData = todoAPI.getListTodo()

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
                val todoData = todoAPI.getTodo(todoId).toTodo()

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