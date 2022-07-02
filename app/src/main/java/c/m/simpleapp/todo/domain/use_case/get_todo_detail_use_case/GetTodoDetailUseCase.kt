package c.m.simpleapp.todo.domain.use_case.get_todo_detail_use_case

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.todo.domain.model.Todo
import c.m.simpleapp.todo.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow

class GetTodoDetailUseCase(private val todoRepository: TodoRepository) {
    suspend operator fun invoke(todoId: Int): Flow<Resource<Todo>> {
        return todoRepository.getTodo(todoId)
    }
}