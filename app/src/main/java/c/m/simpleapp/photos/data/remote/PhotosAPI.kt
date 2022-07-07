package c.m.simpleapp.photos.data.remote

import c.m.simpleapp.photos.data.remote.dto.PhotoDTO
import retrofit2.http.GET

interface PhotosAPI {
    @GET("/photos")
    suspend fun getListPhotos(): List<PhotoDTO>
}