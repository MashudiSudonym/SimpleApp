package c.m.simpleapp.todo.domain.use_case.get_list_todo_use_case

import c.m.simpleapp.dummy.todo.FakeDummyTodoData
import c.m.simpleapp.todo.data.repository.FakeTodoRepository
import c.m.simpleapp.todo.domain.model.Todo
import c.m.simpleapp.todo.domain.repository.TodoRepository
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetListTodoUseCaseTest {
    private lateinit var getListTodoUseCase: GetListTodoUseCase
    private lateinit var fakeTodoRepository: TodoRepository
    private lateinit var fakeListTodo: List<Todo>

    @Before
    fun setUp() {
        fakeListTodo = FakeDummyTodoData().fakeListTodo()
        fakeTodoRepository = FakeTodoRepository()
        getListTodoUseCase = GetListTodoUseCase(fakeTodoRepository)
    }

    @Test
    @Throws(Exception::class)
    fun `check data return according to fake data`() = runBlocking {
        val data = getListTodoUseCase().last().data
        val fakeData = fakeListTodo

        Truth.assertThat(data).isEqualTo(fakeData)
    }
}