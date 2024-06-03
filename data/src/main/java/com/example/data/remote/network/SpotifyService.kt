package com.example.data.remote.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpotifyService {
    //Get Top Artist
    @GET("/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks")
    suspend fun getTopTracksModel(
        @Query("api_key") apiKey: String = "BQDbvqu6nJrt9C_X3uUV0XGV2cd0ocda3mK04bRHT4TglVYnMAsAtpEHIVj7V0MpbRULgasjZ5YI0o7EhnRBca9wX_Z411tqLEohhLlw08XXemINaV0"
        // @Query("page") page: Int
    ): TopTracksModel

//    @GET("movie/{movieId}")
//    suspend fun getMovie(
//        @Path("movieId") movieId: Int?,
//        @Query("api_key") apiKey: String = "BQDL5SWz0c025cILiYAWE-3js_J2wXJ2r6_ugY342rsDtkKCrV6xeIAFd1_qWy6WMebl-wTWIFnOYRcYmtRvBYdC9qT5Om0xwFA2HDfYswMGhsqRidw"
//    ): MovieItem

}