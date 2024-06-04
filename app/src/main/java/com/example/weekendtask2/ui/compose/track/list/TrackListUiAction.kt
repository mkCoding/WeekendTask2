package com.example.weekendtask2.ui.compose.track.list

import com.example.common.state.UiAction
import com.example.data.remote.network.AlbumModel
import com.example.domain.entity.ArtistModelX

sealed class TrackListUiAction:UiAction {
    data object Load : TrackListUiAction()

    //Add all values that you want to display on the details screen
    data class OnMovieItemClick(
        val trackId: Int?,
        val artist:List<ArtistModelX>?,
//        val album:AlbumModel?,
        val trackName:String?,
        val duration:Int?,
        val explicit:Boolean?,

        ) : TrackListUiAction()

}