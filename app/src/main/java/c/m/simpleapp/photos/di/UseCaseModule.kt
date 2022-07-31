package c.m.simpleapp.photos.di

import c.m.simpleapp.photos.domain.repository.PhotosRepository
import c.m.simpleapp.photos.domain.use_case.get_list_photos_use_case.GetListPhotosUseCase
import c.m.simpleapp.photos.domain.use_case.get_photo_detail_use_case.GetPhotoDetailUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideGetListPhotosUseCase(photosRepository: PhotosRepository): GetListPhotosUseCase {
        return GetListPhotosUseCase(photosRepository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetPhotoDetailUseCase(photosRepository: PhotosRepository): GetPhotoDetailUseCase {
        return GetPhotoDetailUseCase(photosRepository)
    }
}