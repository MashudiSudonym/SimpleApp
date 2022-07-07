package c.m.simpleapp.posts.di

import c.m.simpleapp.common.data.local.LocalDatabase
import c.m.simpleapp.posts.data.local.PostsDao
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
    fun providePostsDao(localDatabase: LocalDatabase): PostsDao {
        return localDatabase.postsDao()
    }
}