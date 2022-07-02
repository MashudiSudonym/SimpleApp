package c.m.simpleapp.todo.data.mapper

import c.m.simpleapp.todo.data.remote.dto.TodoDTO
import c.m.simpleapp.todo.domain.model.Todo

fun TodoDTO.toTodo(): Todo {
    return Todo(userId = userId, id = id, title = title, completed = completed)
}