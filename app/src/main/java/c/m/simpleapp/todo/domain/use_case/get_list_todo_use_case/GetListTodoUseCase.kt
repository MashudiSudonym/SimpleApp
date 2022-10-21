package c.m.simpleapp.todo.domain.use_case.get_list_todo_use_case

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.todo.domain.model.Todo
import c.m.simpleapp.todo.domain.repository.TodoRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class GetListTodoUseCase @Inject constructor(private val todoRepository: TodoRepository) {
    suspend operator fun invoke(): Flow<Resource<List<Todo>>> {
        return todoRepository.getListTodo()
    }
}