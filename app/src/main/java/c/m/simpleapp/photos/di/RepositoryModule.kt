package c.m.simpleapp.photos.di

import c.m.simpleapp.photos.data.repository.PhotosRepositoryImpl
import c.m.simpleapp.photos.domain.repository.PhotosRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Provides
    @Binds
    abstract fun bindPhotosRepository(photosRepositoryImpl: PhotosRepositoryImpl): PhotosRepository
}