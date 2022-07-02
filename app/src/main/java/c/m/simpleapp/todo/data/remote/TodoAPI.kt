package c.m.simpleapp.todo.data.remote

import c.m.simpleapp.todo.data.remote.dto.TodoDTO
import c.m.simpleapp.todo.domain.model.Todo
import retrofit2.http.GET
import retrofit2.http.Path

interface TodoAPI {
    @GET("/todos")
    suspend fun getListTodo(): List<Todo>

    @GET("/todos/{todoId}")
    suspend fun getTodo(@Path("todoId") todoId: Int): TodoDTO
}