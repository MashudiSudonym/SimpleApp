package c.m.simpleapp.todos.data.remote

import c.m.simpleapp.todos.data.remote.dto.TodoDTO
import c.m.simpleapp.todos.data.remote.dto.TodosDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface TodosAPI {
    @GET("/todos")
    suspend fun getTodos(): TodosDTO

    @GET("/todos/{todoId}")
    suspend fun getTodo(@Path("todoId") todoId: Int): TodoDTO
}