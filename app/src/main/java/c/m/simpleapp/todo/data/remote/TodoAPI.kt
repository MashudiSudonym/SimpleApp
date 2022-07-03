package c.m.simpleapp.todo.data.remote

import c.m.simpleapp.todo.data.remote.dto.TodoDTO
import retrofit2.http.GET

interface TodoAPI {
    @GET("/todos")
    suspend fun getListTodo(): List<TodoDTO>
}