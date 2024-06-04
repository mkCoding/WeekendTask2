package com.example.data.local.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.db.TrackDao
import com.example.data.local.db.TrackDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
@Module
@InstallIn(SingletonComponent::class)
class PersistanceModule {

    @Provides
    fun provideMovieDatabase(@ApplicationContext context: Context): TrackDatabase =
        Room.databaseBuilder(
            context,
            TrackDatabase::class.java, "movie-database"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideMovieDao(database: TrackDatabase): TrackDao = database.trackDao()
}

