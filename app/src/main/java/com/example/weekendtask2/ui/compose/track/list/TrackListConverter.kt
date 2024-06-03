package com.example.weekendtask2.ui.compose.track.list

import android.content.Context
import com.example.common.state.CommonResultConverter
import com.example.data.remote.network.TrackModel
import com.example.domain.usecase.GetTracksUseCase
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TrackListConverter @Inject constructor(
    @ApplicationContext private val context: Context
): CommonResultConverter<GetTracksUseCase.Response, TrackListModel>() {
    override fun convertSuccess(
        data: GetTracksUseCase.Response
    ): TrackListModel {


        return TrackListModel(
            items = data.tracks!!.map {
                TrackListItemModel(
                    it?.album,
                    it?.artists,
                    it?.availableMarkets,
                    it?.discNumber,
                    it?.durationMs,
                    it?.explicit,
                    it?.externalIds,
                    it?.externalUrls,
                    it?.href,
                    it?.id,
                    it?.isLocal,
                    it?.name,
                    it?.popularity,
                    it?.previewUrl,
                    it?.trackNumber,
                    it?.type,
                    it?.uri
                )
            }
        )

    }


}