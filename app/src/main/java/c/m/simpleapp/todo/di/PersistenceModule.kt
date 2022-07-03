package c.m.simpleapp.todo.di

import android.content.Context
import androidx.room.Room
import c.m.simpleapp.common.util.Constants
import c.m.simpleapp.todo.data.local.TodoLocalDatabase
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
    fun provideTodoLocalDatabase(@ApplicationContext context: Context): TodoLocalDatabase {
        return Room.databaseBuilder(context, TodoLocalDatabase::class.java, Constants.TODO_DB)
            .fallbackToDestructiveMigration()
            .build()
    }
}