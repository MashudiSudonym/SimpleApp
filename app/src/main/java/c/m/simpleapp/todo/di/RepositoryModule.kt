package c.m.simpleapp.todo.di

import c.m.simpleapp.todo.data.remote.TodoAPI
import c.m.simpleapp.todo.data.repository.TodoRepositoryImpl
import c.m.simpleapp.todo.domain.repository.TodoRepository
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
    fun provideTodoRepository(todoAPI: TodoAPI): TodoRepository {
        return TodoRepositoryImpl(todoAPI)
    }
}