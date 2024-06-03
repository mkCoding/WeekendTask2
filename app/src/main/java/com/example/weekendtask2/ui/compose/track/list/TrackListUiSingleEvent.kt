package com.example.weekendtask2.ui.compose.track.list

import com.example.common.state.UiSingleEvent

sealed class TrackListUiSingleEvent:UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String) : TrackListUiSingleEvent()

}