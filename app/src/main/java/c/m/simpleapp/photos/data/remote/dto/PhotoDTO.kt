package c.m.simpleapp.photos.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PhotoDTO(
    @SerializedName("albumId")
    val albumId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,
)
