package com.example.data.local.di

import com.example.data.local.source.LocalTrackDataSourceImpl
import com.example.data.repo.local.LocalTrackDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

class LocalDataSourceModule {
    @Module
    @InstallIn(SingletonComponent::class)
    abstract class LocalDataSourceModule {

        @Binds
        abstract fun bindTrackDataSource(dataSource: LocalTrackDataSourceImpl): LocalTrackDataSource
    }

}