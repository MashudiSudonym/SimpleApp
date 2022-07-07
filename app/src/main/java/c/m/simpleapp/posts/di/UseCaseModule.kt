package c.m.simpleapp.posts.di

import c.m.simpleapp.posts.domain.repository.PostsRepository
import c.m.simpleapp.posts.domain.use_case.get_list_posts_use_case.GetListPostsUseCase
import c.m.simpleapp.posts.domain.use_case.get_post_detail_use_case.GetPostDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetListPostsUseCase(postsRepository: PostsRepository): GetListPostsUseCase {
        return GetListPostsUseCase(postsRepository)
    }

    @Provides
    @Singleton
    fun provideGetPostDetailUseCase(postsRepository: PostsRepository): GetPostDetailUseCase {
        return GetPostDetailUseCase(postsRepository)
    }
}