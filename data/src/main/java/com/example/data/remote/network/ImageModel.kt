package com.example.data.remote.network


import com.google.gson.annotations.SerializedName

data class ImageModel(
    @SerializedName("height")
    val height: Int? = 0,
    @SerializedName("url")
    val url: String? = "",
    @SerializedName("width")
    val width: Int? = 0
)