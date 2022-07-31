package c.m.simpleapp.todo.di

import c.m.simpleapp.todo.domain.repository.TodoRepository
import c.m.simpleapp.todo.domain.use_case.get_list_todo_use_case.GetListTodoUseCase
import c.m.simpleapp.todo.domain.use_case.get_todo_detail_use_case.GetTodoDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideGetListTodoUseCase(todoRepository: TodoRepository): GetListTodoUseCase {
        return GetListTodoUseCase(todoRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetTodoDetailUseCase(todoRepository: TodoRepository): GetTodoDetailUseCase {
        return GetTodoDetailUseCase(todoRepository)
    }
}