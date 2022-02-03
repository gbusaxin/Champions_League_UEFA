package com.example.championsleagueuefa.data.di

import android.content.Context
import androidx.room.Room
import com.example.championsleagueuefa.data.database.AppDatabase
import com.example.championsleagueuefa.data.database.DbDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RoomModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DB_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDbDao(database: AppDatabase): DbDao {
        return database.getDao()
    }

}