package c.m.simpleapp.todos.data.mapper

import c.m.simpleapp.todos.data.remote.dao.TodosDTO
import c.m.simpleapp.todos.domain.model.Todos

fun TodosDTO.toTodos(): Todos {
    return Todos(todos = todos.map { it.toTodo() })
}

fun Todos.toTodosDTO(): TodosDTO {
    return TodosDTO(todos = todos.map { it.toTodoDTO() })
}