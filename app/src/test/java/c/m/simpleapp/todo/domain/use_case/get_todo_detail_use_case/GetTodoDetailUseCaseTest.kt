package c.m.simpleapp.todo.domain.use_case.get_todo_detail_use_case

import c.m.simpleapp.dummy.todo.FakeDummyTodoData
import c.m.simpleapp.todo.data.repository.FakeTodoRepository
import c.m.simpleapp.todo.domain.model.Todo
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetTodoDetailUseCaseTest {
    private lateinit var getTodoDetailUseCase: GetTodoDetailUseCase
    private lateinit var fakeTodoRepository: FakeTodoRepository
    private lateinit var fakeTodo: Todo

    @Before
    fun setUp() {
        fakeTodo = FakeDummyTodoData().fakeTodo()
        fakeTodoRepository = FakeTodoRepository()
        getTodoDetailUseCase = GetTodoDetailUseCase(fakeTodoRepository)
    }

    @Test
    @Throws(Exception::class)
    fun `check data return according to fake data`() = runBlocking {
        val data = getTodoDetailUseCase(1).last().data
        val fakeData = fakeTodo

        Truth.assertThat(data).isEqualTo(fakeData)
    }
}