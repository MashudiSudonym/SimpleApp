package c.m.simpleapp.photos.data.repository

import c.m.simpleapp.R
import c.m.simpleapp.common.util.Resource
import c.m.simpleapp.common.util.UIText
import c.m.simpleapp.photos.data.local.PhotosDao
import c.m.simpleapp.photos.data.mapper.toPhoto
import c.m.simpleapp.photos.data.mapper.toPhotoEntity
import c.m.simpleapp.photos.data.remote.PhotosAPI
import c.m.simpleapp.photos.domain.model.Photo
import c.m.simpleapp.photos.domain.repository.PhotosRepository
import coil.network.HttpException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val photosAPI: PhotosAPI,
    private val photosDao: PhotosDao,
) :
    PhotosRepository {
    override suspend fun getListPhotos(): Flow<Resource<List<Photo>>> {
        return flow {
            emit(Resource.Loading())

            val listPhotoFromLocal = photosDao.getListPhotos().map { it.toPhoto() }

            emit(Resource.Loading(listPhotoFromLocal))

            try {
                val listPhotoFromRemote = photosAPI.getListPhotos()

                listPhotoFromRemote.forEach { photo ->
                    photosDao.updatePhotos(photo.id, photo.toPhotoEntity())
                }

                val newListPhotoFromLocal = photosDao.getListPhotos().map { it.toPhoto() }

                emit(Resource.Success(newListPhotoFromLocal))
            } catch (e: HttpException) {
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_internet_problem),
                        data = listPhotoFromLocal)
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_internet_problem),
                        data = listPhotoFromLocal)
                )
            } catch (e: UnknownHostException) {
                emit(
                    Resource.Error(message = UIText.StringResource(R.string.error_unknown),
                        data = listPhotoFromLocal)
                )
            }
        }.flowOn(Dispatchers.IO)
    }
}