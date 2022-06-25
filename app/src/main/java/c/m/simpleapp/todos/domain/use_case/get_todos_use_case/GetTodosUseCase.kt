package c.m.simpleapp.todos.domain.use_case.get_todos_use_case

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.todos.domain.model.Todos
import c.m.simpleapp.todos.domain.repository.TodosRepository
import kotlinx.coroutines.flow.Flow

class GetTodosUseCase(private val todosRepository: TodosRepository) {
    suspend operator fun invoke(): Flow<Resource<Todos>> {
        return todosRepository.getTodos()
    }
}