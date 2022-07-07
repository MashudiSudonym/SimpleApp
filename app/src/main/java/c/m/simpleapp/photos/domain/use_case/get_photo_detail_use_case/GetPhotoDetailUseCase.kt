package c.m.simpleapp.photos.domain.use_case.get_photo_detail_use_case

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.photos.domain.model.Photo
import c.m.simpleapp.photos.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow

class GetPhotoDetailUseCase(private val photosRepository: PhotosRepository) {
    suspend operator fun invoke(photoId: Int): Flow<Resource<Photo>> {
        return photosRepository.getPhoto(photoId)
    }
}