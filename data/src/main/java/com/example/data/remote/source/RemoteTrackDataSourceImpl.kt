package com.example.data.remote.source

import androidx.lifecycle.LiveData
import com.example.data.remote.network.SpotifyService
import com.example.data.remote.network.TopTracksModel
import com.example.data.remote.network.TrackModel
import com.example.data.repo.remote.RemoteTrackDataSource
import com.example.domain.entity.Track
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteTrackDataSourceImpl @Inject constructor(
    private val service: SpotifyService
):RemoteTrackDataSource {
    
    override fun getTopTracks(): Flow<TopTracksModel>? =flow {
        emit(service.getTopTracksModel())}
    .catch {
        throw UseCaseException.TrackException(it)
    }

    override fun getTracks(): Flow<List<Track?>> = flow {
        emit(service.getTracks())
    }.catch {
        throw UseCaseException.TrackException(it)
    }

    override fun getTrack(trackId: Int?): Flow<Track> {
        TODO("Not yet implemented")
    }

//    override fun getTrack(trackId: Int?): Flow<TrackModel> =
//        flow {
//        val trackModel = service.getTrack(trackId)
//        emit(convert(trackModel))
//    }.catch {
//        throw UseCaseException.TrackException(it)
//    }



    private fun convert(model: TrackModel?) =
        TrackModel(
            model?.album, model?.artists, model?.availableMarkets, model?.discNumber, model?.durationMs,
            model?.explicit, model?.externalIds, model?.externalUrls, model?.href,
            model?.id, model?.isLocal, model?.name, model?.popularity, model?.previewUrl,
            model?.trackNumber,model?.type, model?.uri
        )
}
