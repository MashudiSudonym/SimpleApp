package c.m.simpleapp.todos.di

import c.m.simpleapp.todos.domain.repository.TodosRepository
import c.m.simpleapp.todos.domain.use_case.get_todo_detail.GetTodoDetail
import c.m.simpleapp.todos.domain.use_case.get_todos.GetTodos
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
    fun provideGetTodos(todosRepository: TodosRepository): GetTodos {
        return GetTodos(todosRepository)
    }

    @Provides
    @Singleton
    fun provideGetTodoDetail(todosRepository: TodosRepository): GetTodoDetail {
        return GetTodoDetail(todosRepository)
    }
}