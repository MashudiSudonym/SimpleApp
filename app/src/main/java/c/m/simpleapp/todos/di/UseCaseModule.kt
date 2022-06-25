package c.m.simpleapp.todos.di

import c.m.simpleapp.todos.domain.repository.TodosRepository
import c.m.simpleapp.todos.domain.use_case.get_todo_detail_use_case.GetTodoDetailUseCase
import c.m.simpleapp.todos.domain.use_case.get_todos_use_case.GetTodosUseCase
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
    fun provideGetTodosUseCase(todosRepository: TodosRepository): GetTodosUseCase {
        return GetTodosUseCase(todosRepository)
    }

    @Provides
    @Singleton
    fun provideGetTodoDetailUseCase(todosRepository: TodosRepository): GetTodoDetailUseCase {
        return GetTodoDetailUseCase(todosRepository)
    }
}