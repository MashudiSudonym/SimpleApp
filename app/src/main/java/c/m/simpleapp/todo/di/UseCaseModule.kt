package c.m.simpleapp.todo.di

import c.m.simpleapp.todo.domain.repository.TodoRepository
import c.m.simpleapp.todo.domain.use_case.get_list_todo_use_case.GetListTodoUseCase
import c.m.simpleapp.todo.domain.use_case.get_todo_detail_use_case.GetTodoDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetListTodoUseCase(todoRepository: TodoRepository): GetListTodoUseCase {
        return GetListTodoUseCase(todoRepository)
    }

    @Provides
    @Singleton
    fun provideGetTodoDetailUseCase(todosRepository: TodoRepository): GetTodoDetailUseCase {
        return GetTodoDetailUseCase(todosRepository)
    }
}