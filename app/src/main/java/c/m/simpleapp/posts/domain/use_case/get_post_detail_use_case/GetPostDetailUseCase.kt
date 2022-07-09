package c.m.simpleapp.posts.domain.use_case.get_post_detail_use_case

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.posts.domain.model.Post
import c.m.simpleapp.posts.domain.repository.PostsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostDetailUseCase @Inject constructor(private val postsRepository: PostsRepository) {
    suspend operator fun invoke(postId: Int): Flow<Resource<Post>> {
        return postsRepository.getPost(postId)
    }
}