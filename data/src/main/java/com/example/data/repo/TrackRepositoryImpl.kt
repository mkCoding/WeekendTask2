package com.example.data.repo

import com.example.data.repo.local.LocalTrackDataSource
import com.example.data.repo.remote.RemoteTrackDataSource
import com.example.domain.entity.Track
import com.example.domain.repo.TrackRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class TrackRepositoryImpl @Inject constructor(
    private val remoteSource: RemoteTrackDataSource,
    private val localSource: LocalTrackDataSource

) :TrackRepository{
    override fun getTracks(): Flow<List<Track?>?> =
        remoteSource.getTracks().onEach {
            localSource.getTracks(it)
        }

    override fun getTrack(trackId: Int?): Flow<Track> =
        remoteSource.getTrack(trackId).onEach{
            localSource.addTracks(listOf(it))
        }




}