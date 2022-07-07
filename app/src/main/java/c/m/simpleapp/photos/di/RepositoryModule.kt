package c.m.simpleapp.photos.di

import c.m.simpleapp.photos.data.local.PhotosDao
import c.m.simpleapp.photos.data.remote.PhotosAPI
import c.m.simpleapp.photos.data.repository.PhotosRepositoryImpl
import c.m.simpleapp.photos.domain.repository.PhotosRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providePhotosRepository(photosAPI: PhotosAPI, photosDao: PhotosDao): PhotosRepository {
        return PhotosRepositoryImpl(photosAPI, photosDao)
    }
}