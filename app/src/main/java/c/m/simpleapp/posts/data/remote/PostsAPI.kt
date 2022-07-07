package c.m.simpleapp.posts.data.remote

import c.m.simpleapp.posts.data.remote.dto.PostDTO
import retrofit2.http.GET

interface PostsAPI {
    @GET("/posts")
    suspend fun getListPosts(): List<PostDTO>
}