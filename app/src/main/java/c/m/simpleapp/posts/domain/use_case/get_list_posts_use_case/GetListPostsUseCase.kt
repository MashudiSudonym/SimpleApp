package c.m.simpleapp.posts.domain.use_case.get_list_posts_use_case

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.posts.domain.model.Post
import c.m.simpleapp.posts.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListPostsUseCase @Inject constructor(private val postsRepository: PostsRepository) {
    suspend operator fun invoke(): Flow<Resource<List<Post>>> {
        return postsRepository.getListPosts()
    }
}