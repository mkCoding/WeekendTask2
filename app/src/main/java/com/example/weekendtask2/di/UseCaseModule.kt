package com.example.weekendtask2.di

import com.example.domain.entity.Track
import com.example.domain.repo.TrackRepository
import com.example.domain.usecase.GetTracksByIdUseCase
import com.example.domain.usecase.GetTracksUseCase
import com.example.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    fun provideUseCaseConfiguration(): UseCase.Configuration = UseCase.Configuration(Dispatchers.IO)

    @Provides
    fun provideGetTracksUseCase(
        configuration: UseCase.Configuration,
        repository: TrackRepository
    ): GetTracksUseCase = GetTracksUseCase(
        configuration,
        repository
    )

    @Provides
    fun GetTracksByIdUseCase(
        configuration: UseCase.Configuration,
        repository: TrackRepository
    ): GetTracksByIdUseCase = GetTracksByIdUseCase(
        configuration,
        repository
    )

}