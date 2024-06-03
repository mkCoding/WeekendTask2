package com.example.data.remote.source

import com.example.data.remote.network.SpotifyService
import com.example.data.remote.network.TrackModel
import com.example.data.repo.remote.RemoteTrackDataSource
import com.example.domain.entity.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteTopAlbumnDataSourceImpl @Inject constructor(
    private val service: SpotifyService
):RemoteTrackDataSource {


    override fun getTracks(): Flow<List<TrackModel?>?> = flow {
        emit(service.getTopTracksModel())
    }.map { model ->
        model.tracks?.map { apiModel ->
            convert(apiModel)
        }
    }.catch {
        throw UseCaseException.TrackException(it)
    }
//
//    override fun getTrack(trackId: String?): Flow<TrackModel?>? = flow {
//        emit(service.getTopTracksModel())
//    }.map {
//        convert(it)
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
