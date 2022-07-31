package c.m.simpleapp.posts.di

import c.m.simpleapp.posts.domain.repository.PostsRepository
import c.m.simpleapp.posts.domain.use_case.get_list_posts_use_case.GetListPostsUseCase
import c.m.simpleapp.posts.domain.use_case.get_post_detail_use_case.GetPostDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideGetListPostsUseCase(postsRepository: PostsRepository): GetListPostsUseCase {
        return GetListPostsUseCase(postsRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetPostDetailUseCase(postsRepository: PostsRepository): GetPostDetailUseCase {
        return GetPostDetailUseCase(postsRepository)
    }
}