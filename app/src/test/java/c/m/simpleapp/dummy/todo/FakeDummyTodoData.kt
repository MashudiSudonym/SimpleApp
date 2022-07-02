package c.m.simpleapp.dummy.todo

import c.m.simpleapp.todo.domain.model.Todo

class FakeDummyTodoData {
    private val fakeListTodoData: ArrayList<Todo> = arrayListOf()
    private val fakeTodoData: Todo = Todo(
        userId = 1,
        id = 1,
        title = "delectus aut autem",
        completed = false
    )

    fun fakeListTodo(): List<Todo> {
        fakeListTodoData.add(fakeTodoData)
        return fakeListTodoData
    }

    fun fakeTodo(): Todo = fakeTodoData
}