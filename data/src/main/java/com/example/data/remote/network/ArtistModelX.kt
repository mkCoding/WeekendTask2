package com.example.data.remote.network


import com.google.gson.annotations.SerializedName

data class ArtistModelX(
    @SerializedName("external_urls")
    val externalUrls: ExternalUrlsModelXXX? = ExternalUrlsModelXXX(),
    @SerializedName("href")
    val href: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("uri")
    val uri: String? = ""
)