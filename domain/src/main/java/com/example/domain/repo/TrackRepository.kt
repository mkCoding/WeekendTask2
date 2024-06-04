package com.example.domain.repo

import com.example.domain.entity.Track
import kotlinx.coroutines.flow.Flow

interface TrackRepository{
    fun getTracks(): Flow<List<Track?>?>

    fun getTrack(trackId: Int?): Flow<Track>
}