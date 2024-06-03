package com.example.data.remote.network


import com.google.gson.annotations.SerializedName

data class AlbumModel(
    @SerializedName("album_type")
    val albumType: String? = "",
    @SerializedName("artists")
    val artists: List<ArtistModelX>? = listOf(),
    @SerializedName("available_markets")
    val availableMarkets: List<String>? = listOf(),
    @SerializedName("external_urls")
    val externalUrls: ExternalUrlsModelXXX? = ExternalUrlsModelXXX(),
    @SerializedName("href")
    val href: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("images")
    val images: List<ImageModel>? = listOf(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("release_date")
    val releaseDate: String? = "",
    @SerializedName("release_date_precision")
    val releaseDatePrecision: String? = "",
    @SerializedName("total_tracks")
    val totalTracks: Int? = 0,
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("uri")
    val uri: String? = ""
)