package c.m.simpleapp.todo.di

import c.m.simpleapp.todo.data.remote.TodoAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideTodosAPI(retrofit: Retrofit): TodoAPI {
        return retrofit.create(TodoAPI::class.java)
    }
}