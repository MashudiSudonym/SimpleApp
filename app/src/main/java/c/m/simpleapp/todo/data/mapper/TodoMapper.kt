package c.m.simpleapp.todo.data.mapper

import c.m.simpleapp.todo.data.local.entity.TodoEntity
import c.m.simpleapp.todo.data.remote.dto.TodoDTO
import c.m.simpleapp.todo.domain.model.Todo

fun TodoDTO.toTodoEntity(): TodoEntity {
    return TodoEntity(userId = userId, todoId = id, title = title, completed = completed)
}

fun TodoEntity.toTodo(): Todo {
    return Todo(userId = userId, id = todoId, title = title, completed = completed)
}