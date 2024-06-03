package com.example.data.repo.local

import com.example.domain.entity.Track
import kotlinx.coroutines.flow.Flow

interface LocalTrackDataSource {

    fun getTracks(tracks: List<Track?>?): Flow<List<Track>>
    fun getTrack(trackId: Int?): Flow<Track>

    suspend fun addTracks(movies: List<Track?>?)

}