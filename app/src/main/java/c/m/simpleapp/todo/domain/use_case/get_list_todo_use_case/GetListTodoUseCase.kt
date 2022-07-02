package c.m.simpleapp.todo.domain.use_case.get_list_todo_use_case

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.todo.domain.model.Todo
import c.m.simpleapp.todo.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class GetListTodoUseCase(private val todoRepository: TodoRepository) {
    suspend operator fun invoke(): Flow<Resource<List<Todo>>> {
        return todoRepository.getListTodo()
    }
}