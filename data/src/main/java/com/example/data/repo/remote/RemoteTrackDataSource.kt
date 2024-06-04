package com.example.data.repo.remote

import com.example.data.remote.network.TopTracksModel
import com.example.data.remote.network.TrackModel
import com.example.domain.entity.Track
import kotlinx.coroutines.flow.Flow

interface RemoteTrackDataSource {

    fun getTopTracks(): Flow<TopTracksModel>? //list of  Top tracks

    fun getTracks(): Flow<List<Track?>?> //list of all tracks

    fun getTrack(trackId: Int?): Flow<Track> //a track
}

