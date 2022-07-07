package c.m.simpleapp.posts.di

import c.m.simpleapp.posts.data.local.PostsDao
import c.m.simpleapp.posts.data.remote.PostsAPI
import c.m.simpleapp.posts.data.repository.PostsRepositoryImpl
import c.m.simpleapp.posts.domain.repository.PostsRepository
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
    fun providePostsRepository(postsAPI: PostsAPI, postsDao: PostsDao): PostsRepository {
        return PostsRepositoryImpl(postsAPI, postsDao)
    }
}