package c.m.simpleapp.common.di

import android.content.Context
import androidx.room.Room
import c.m.simpleapp.common.data.local.LocalDatabase
import c.m.simpleapp.common.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideLocalDatabase(@ApplicationContext context: Context): LocalDatabase {
        return Room.databaseBuilder(context, LocalDatabase::class.java, Constants.TODO_DB)
            .fallbackToDestructiveMigration()
            .build()
    }
}