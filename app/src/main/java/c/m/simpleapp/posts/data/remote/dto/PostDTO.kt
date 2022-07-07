package c.m.simpleapp.posts.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PostDTO(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String,
)
