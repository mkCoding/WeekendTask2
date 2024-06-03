package com.example.weekendtask2.di

import com.example.data.repo.TrackRepositoryImpl
import com.example.data.repo.local.LocalTrackDataSource
import com.example.data.repo.remote.RemoteTrackDataSource
import com.example.domain.repo.TrackRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideMovieRepository(
        remoteSource: RemoteTrackDataSource,
        localSource: LocalTrackDataSource
    ): TrackRepository = TrackRepositoryImpl(
        remoteSource,
        localSource
    )
}