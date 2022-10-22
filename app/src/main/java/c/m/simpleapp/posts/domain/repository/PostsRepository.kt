package c.m.simpleapp.posts.domain.repository

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.posts.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    suspend fun getListPosts(): Flow<Resource<List<Post>>>
}