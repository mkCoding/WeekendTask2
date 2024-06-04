package com.example.common.nav

import com.example.domain.entity.ArtistModelX


data class TrackInput(
    val trackId: Int?,
    val artist: List<ArtistModelX>?,
//    val album: AlbumModel?,
    val trackName:String?,
    val durationMs: Int?,
//    val releaseDate:String?,
    val explicit: Boolean?
)
