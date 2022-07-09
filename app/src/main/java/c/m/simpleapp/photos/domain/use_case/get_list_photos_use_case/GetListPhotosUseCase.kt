package c.m.simpleapp.photos.domain.use_case.get_list_photos_use_case

import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.photos.domain.model.Photo
import c.m.simpleapp.photos.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetListPhotosUseCase @Inject constructor(private val photosRepository: PhotosRepository) {
    suspend operator fun invoke(): Flow<Resource<List<Photo>>> {
        return photosRepository.getListPhotos()
    }
}