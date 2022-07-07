package c.m.simpleapp.photos.di

import c.m.simpleapp.photos.data.remote.PhotosAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providePhotosAPI(retrofit: Retrofit): PhotosAPI {
        return retrofit.create(PhotosAPI::class.java)
    }
}