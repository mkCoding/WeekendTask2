package com.example.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.entity.ExternalIdsModel
import com.example.domain.entity.ExternalUrlsModelXXX
import com.example.domain.entity.AlbumModel
import com.example.domain.entity.ArtistModelX

@Entity(tableName = "track")
data class TrackEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "trackId") val trackId: String? = "",
    @ColumnInfo(name = "album") val album: AlbumModel? = null,
    @ColumnInfo(name = "artist") val artist: List<ArtistModelX>? = null,
    @ColumnInfo(name = "availableMarkets") val availableMarkets:List<String>? = null,
    @ColumnInfo(name = "discNumber") val discNumber: Int? = null,
    @ColumnInfo(name = "durationMs") val durationMs: Int? = null,
    @ColumnInfo(name = "explicit") val explicit: Boolean? = null,
    @ColumnInfo(name = "externalIds") val externalIds: ExternalIdsModel? = null,
    @ColumnInfo(name = "externalUrls") val externalUrls: ExternalUrlsModelXXX? = null,
    @ColumnInfo(name = "href") val href: String? = null,
    @ColumnInfo(name = "isLocal") val isLocal: Boolean? = null,
    @ColumnInfo(name = "name") val name: String? = null,
    @ColumnInfo(name = "popularity") val popularity: Int? = null,
    @ColumnInfo(name = "previewUrl") val previewUrl: String? = null,

    @ColumnInfo(name = "trackNumber") val trackNumber: Int? = null,
    @ColumnInfo(name = "type") val type: String? = null,
    @ColumnInfo(name = "uri") val uri: String? = null

)