package c.m.simpleapp.photos.di

import c.m.simpleapp.photos.data.repository.PhotosRepositoryImpl
import c.m.simpleapp.photos.domain.repository.PhotosRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPhotosRepository(photosRepositoryImpl: PhotosRepositoryImpl): PhotosRepository
}