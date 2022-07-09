package c.m.simpleapp.todo.data.repository

import c.m.simpleapp.R
import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.common.util.UIText
import c.m.simpleapp.todo.data.local.TodoDao
import c.m.simpleapp.todo.data.mapper.toTodo
import c.m.simpleapp.todo.data.mapper.toTodoEntity
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
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val todoAPI: TodoAPI,
    private val todoDao: TodoDao,
) :
    TodoRepository {
    override suspend fun getListTodo(): Flow<Resource<List<Todo>>> {
        return flow {
            emit(Resource.Loading())

            // Load old to-do list from local source
            val listTodoFromLocal = todoDao.getListTodo().map { it.toTodo() }

            // Show old to-do list when is loading ui state
            emit(Resource.Loading(listTodoFromLocal))

            try {
                // Load to-do list from remote source
                val listTodoDataFromRemote = todoAPI.getListTodo()

                // Save to-do list from remote source to local source
                listTodoDataFromRemote.forEach { todo ->
                    todoDao.updateTodo(todo.id, todo.toTodoEntity())
                }
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

            // Load new to-do list from local source
            val newListTodoFromLocal = todoDao.getListTodo().map { it.toTodo() }

            // Show to-do list to success ui state
            emit(Resource.Success(newListTodoFromLocal))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getTodo(todoId: Int): Flow<Resource<Todo>> {
        return flow {
            emit(Resource.Loading())

            try {
                val todoDetailData = todoDao.getTodoDetail(todoId).toTodo()

                emit(Resource.Success(todoDetailData))
            } catch (e: IOException) {
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_internet_problem))
                )
            } catch (e: Exception) {
                emit(
                    Resource.Error(message = UIText.DynamicString(e.toString()))
                )
            }
        }.flowOn(Dispatchers.IO)
    }
}