package com.example.data.remote.network

import com.example.domain.entity.Track
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpotifyService {


    //Get Top Artist
    @GET("/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks") //https://developer.spotify.com/documentation/web-api/reference/get-an-artists-top-tracks
    suspend fun getTopTracksModel(
        // @Query("page") page: Int
    ): TopTracksModel

    /*
    Get all Tracks
    URL: //https://api.spotify.com/v1/tracks/4QNpBfC0zvjKqPJcyqBy9W
    Reference Link: //https://developer.spotify.com/documentation/web-api/reference/get-several-tracks
     */
    @GET("/v1/tracks/")
    suspend fun getTracks(): List<Track>

//    //Get a tracks by ID
//    @GET("/v1/tracks/{trackId}") // https://developer.spotify.com/documentation/web-api/reference/get-track
//    suspend fun getTrack(
//        @Path("trackId") trackId: Int?,
//    ):TrackModel?

}