package com.example.data.remote.network


import com.google.gson.annotations.SerializedName

data class TopTracksModel(
    @SerializedName("tracks")
    val tracks: List<TrackModel>? = listOf()
)