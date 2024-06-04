package com.example.domain.entity

data class AlbumModel(
    val albumType: String? = "",
    val artists: List<ArtistModelX>? = listOf(),
    val availableMarkets: List<String>? = listOf(),
    val externalUrls: ExternalUrlsModelXXX? = ExternalUrlsModelXXX(),
    val href: String? = "",
    val id: String? = "",
    val images: List<ImageModel>? = listOf(),
    val name: String? = "",
    val releaseDate: String? = "",
    val releaseDatePrecision: String? = "",

    val totalTracks: Int? = 0,

    val type: String? = "",

    val uri: String? = ""
)