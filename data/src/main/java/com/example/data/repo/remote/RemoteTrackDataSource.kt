package com.example.data.repo.remote

import com.example.data.remote.network.TrackModel
import com.example.domain.entity.Track
import kotlinx.coroutines.flow.Flow

interface RemoteTrackDataSource {

    fun getTracks(): Flow<List<Track?>?>

    fun getTrack(movieId: Int?): Flow<Track>
}

