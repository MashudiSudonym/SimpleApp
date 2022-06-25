package c.m.simpleapp.todos.domain.use_case.get_todo_detail_use_case

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.todos.domain.model.Todo
import c.m.simpleapp.todos.domain.repository.TodosRepository
import kotlinx.coroutines.flow.Flow

class GetTodoDetailUseCase(private val todosRepository: TodosRepository) {
    suspend operator fun invoke(todoId: Int): Flow<Resource<Todo>> {
        return todosRepository.getTodo(todoId)
    }
}