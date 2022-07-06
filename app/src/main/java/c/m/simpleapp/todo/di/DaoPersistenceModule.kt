package c.m.simpleapp.todo.di

import c.m.simpleapp.common.data.local.LocalDatabase
import c.m.simpleapp.todo.data.local.TodoDao
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
    fun provideTodoDao(localDatabase: LocalDatabase): TodoDao {
        return localDatabase.todoDao()
    }
}