package com.example.data.remote.network


import com.google.gson.annotations.SerializedName

data class TrackModel(
    @SerializedName("album")
    val album: AlbumModel? = AlbumModel(),
    @SerializedName("artists")
    val artists: List<ArtistModelX>? = listOf(),
    @SerializedName("available_markets")
    val availableMarkets: List<String>? = listOf(),
    @SerializedName("disc_number")
    val discNumber: Int? = 0,
    @SerializedName("duration_ms")
    val durationMs: Int? = 0,
    @SerializedName("explicit")
    val explicit: Boolean? = false,
    @SerializedName("external_ids")
    val externalIds: ExternalIdsModel? = ExternalIdsModel(),
    @SerializedName("external_urls")
    val externalUrls: ExternalUrlsModelXXX? = ExternalUrlsModelXXX(),
    @SerializedName("href")
    val href: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("is_local")
    val isLocal: Boolean? = false,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("popularity")
    val popularity: Int? = 0,
    @SerializedName("preview_url")
    val previewUrl: String? = "",
    @SerializedName("track_number")
    val trackNumber: Int? = 0,
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("uri")
    val uri: String? = ""
)