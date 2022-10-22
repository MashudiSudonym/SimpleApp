package c.m.simpleapp.photos.domain.repository

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.photos.domain.model.Photo
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {
    suspend fun getListPhotos(): Flow<Resource<List<Photo>>>
}