package c.m.simpleapp.posts.di

import c.m.simpleapp.posts.data.remote.PostsAPI
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
    fun providePostsAPI(retrofit: Retrofit): PostsAPI {
        return retrofit.create(PostsAPI::class.java)
    }
}