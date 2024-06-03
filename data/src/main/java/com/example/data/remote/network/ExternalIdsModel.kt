package com.example.data.remote.network


import com.google.gson.annotations.SerializedName

data class ExternalIdsModel(
    @SerializedName("isrc")
    val isrc: String? = ""
)