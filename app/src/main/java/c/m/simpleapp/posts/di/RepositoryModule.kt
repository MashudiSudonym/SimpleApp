package c.m.simpleapp.posts.di

import c.m.simpleapp.posts.data.repository.PostsRepositoryImpl
import c.m.simpleapp.posts.domain.repository.PostsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Provides
    @Binds
    abstract fun bindPostsRepository(postsRepositoryImpl: PostsRepositoryImpl): PostsRepository
}