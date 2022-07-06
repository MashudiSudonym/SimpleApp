package c.m.simpleapp.posts.data.remote

import c.m.simpleapp.posts.data.local.PostsDao
import retrofit2.http.GET

interface PostsAPI {
    @GET("/posts")
    suspend fun getListPosts(): List<PostsDao>
}