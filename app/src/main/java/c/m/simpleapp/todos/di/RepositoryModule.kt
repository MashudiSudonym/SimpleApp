package c.m.simpleapp.todos.di

import c.m.simpleapp.todos.data.remote.TodosAPI
import c.m.simpleapp.todos.data.repository.TodosRepositoryImpl
import c.m.simpleapp.todos.domain.repository.TodosRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideTodosRepository(todosAPI: TodosAPI): TodosRepository {
        return TodosRepositoryImpl(todosAPI)
    }
}