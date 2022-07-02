package c.m.simpleapp.todos.data.mapper

import c.m.simpleapp.todos.data.remote.dto.TodoDTO
import c.m.simpleapp.todos.domain.model.Todo

fun TodoDTO.toTodo(): Todo {
    return Todo(userId = userId, id = id, title = title, completed = completed)
}

fun Todo.toTodoDTO(): TodoDTO {
    return TodoDTO(userId = userId, id = id, title = title, completed = completed)
}