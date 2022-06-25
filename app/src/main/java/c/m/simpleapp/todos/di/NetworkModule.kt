package c.m.simpleapp.todos.di

import c.m.simpleapp.todos.data.remote.TodosAPI
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
    fun provideTodosAPI(retrofit: Retrofit): TodosAPI {
        return retrofit.create(TodosAPI::class.java)
    }
}