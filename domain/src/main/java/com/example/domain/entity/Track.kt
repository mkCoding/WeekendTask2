package com.example.domain.entity


import com.example.data.remote.network.AlbumModel
import com.example.data.remote.network.ArtistModelX
import com.example.data.remote.network.ExternalIdsModel
import com.example.data.remote.network.ExternalUrlsModelXXX

data class Track (
    val album: AlbumModel? = AlbumModel(),
    val artists: List<ArtistModelX>? = listOf(),
    val availableMarkets: List<String>? = listOf(),
    val discNumber: Int? = 0,
    val durationMs: Int? = 0,
    val explicit: Boolean? = false,
    val externalIds: ExternalIdsModel? = ExternalIdsModel(),
    val externalUrls: ExternalUrlsModelXXX? = ExternalUrlsModelXXX(),
    val href: String? = "",
    val id: String? = "",
    val isLocal: Boolean? = false,
    val name: String? = "",
    val popularity: Int? = 0,
    val previewUrl: String? = "",
    val trackNumber: Int? = 0,
    val type: String? = "",
    val uri: String? = ""
)
