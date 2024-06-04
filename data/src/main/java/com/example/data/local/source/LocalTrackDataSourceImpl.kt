package com.example.data.local.source

import com.example.data.local.db.TrackDao
import com.example.data.local.db.TrackEntity
import com.example.data.repo.local.LocalTrackDataSource
import com.example.domain.entity.Track
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalTrackDataSourceImpl @Inject constructor(
    private val dao: TrackDao
):LocalTrackDataSource {
    override fun getTracks(tracks: List<Track?>?): Flow<List<Track>> =
        dao.getTracks().map {
            it.map { track ->
                Track(
                    id = track.trackId,
                    album = track.album,
                    artists = track.artist,
                    availableMarkets = track.availableMarkets,
                    discNumber = track.discNumber,
                    durationMs  = track.durationMs,
                    explicit = track.explicit,
                    externalIds = track.externalIds,
                    externalUrls  = track.externalUrls,
                    href = track.href,
                    isLocal = track.isLocal,
                    name = track.name,
                    popularity = track.popularity,
                    previewUrl = track.previewUrl,
                    trackNumber = track.trackNumber,
                    type = track.type,
                    uri = track.uri
                )
            }
        }

    override fun getTrack(trackId: String?): Flow<Track> =
        dao.getTrack(trackId).map {
            Track(
                it.album,
                it.artist,
                it.availableMarkets,
                it.discNumber,
                it.durationMs,
                it.explicit,
                it.externalIds,
                it.externalUrls,
                it.href,
                it.trackId,
                it.isLocal,
                it.name,
                it.popularity,
                it.previewUrl,
                it.trackNumber,
                it.type,
                it.uri
            )
        }


    override suspend fun addTracks(tracks: List<Track?>?) =
        dao.insertTrack(tracks!!.map { track ->
            TrackEntity(
                null,
                album = track?.album,
                artist = track?.artists,
                availableMarkets = track?.availableMarkets,
                discNumber = track?.discNumber,
                durationMs = track?.durationMs,
                explicit = track?.explicit,
                externalIds = track?.externalIds,
                externalUrls = track?.externalUrls,
                href = track?.href,
                isLocal = track?.isLocal,
                name = track?.name,
                popularity = track?.popularity,
                previewUrl = track?.previewUrl,
                trackNumber = track?.trackNumber,
                type = track?.type,
                uri = track?.uri

            )
        })


}