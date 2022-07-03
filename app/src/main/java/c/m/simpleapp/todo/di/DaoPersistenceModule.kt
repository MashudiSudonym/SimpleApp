package c.m.simpleapp.todo.di

import c.m.simpleapp.todo.data.local.TodoDao
import c.m.simpleapp.todo.data.local.TodoLocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoPersistenceModule {
    @Provides
    @Singleton
    fun provideTodoDao(todoLocalDatabase: TodoLocalDatabase): TodoDao {
        return todoLocalDatabase.todoDao()
    }
}