package com.example.data.local.db

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface TrackDao {
    @Query("SELECT * FROM track")
    fun getTracks(): Flow<List<TrackEntity>>

    @Query("SELECT * FROM track WHERE trackId = :trackId")
    fun getTrack(trackId: String?): Flow<TrackEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTrack(movies: List<TrackEntity>)

}