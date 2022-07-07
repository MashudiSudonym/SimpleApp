package c.m.simpleapp.photos.di

import c.m.simpleapp.common.data.local.LocalDatabase
import c.m.simpleapp.photos.data.local.PhotosDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoPersistenceModule {
    @Provides
    @Singleton
    fun providePhotosDao(localDatabase: LocalDatabase): PhotosDao {
        return localDatabase.photosDao()
    }
}