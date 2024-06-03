package com.example.weekendtask2.ui.compose.track.list

import androidx.lifecycle.viewModelScope
import com.example.common.nav.NavRoutes
import com.example.common.nav.TrackInput
import com.example.common.state.MviViewModel
import com.example.common.state.UiState
import com.example.domain.usecase.GetTracksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrackListViewModel @Inject constructor(
    private val useCase: GetTracksUseCase,
    private val converter: TrackListConverter
): MviViewModel<TrackListModel, UiState<TrackListModel>, TrackListUiAction, TrackListUiSingleEvent>() {

    override fun initState(): UiState<TrackListModel> = UiState.Loading

    override fun handleAction(action: TrackListUiAction) {
        when (action) {
            is TrackListUiAction.Load -> {
                loadMovies()
            }


            is TrackListUiAction.OnMovieItemClick -> {
                submitSingleEvent(

                    TrackListUiSingleEvent.OpenDetailsScreen(
                        NavRoutes.Tracks.routeForTracks(
                            TrackInput(
                                action.trackId,
                                action.artist,
                                action.trackName,
                                action.duration,
                                action.explicit
                            )
                        )
                    )
                )
            }
        }
    }

    private fun loadMovies() {
        viewModelScope.launch {
            useCase.execute(GetTracksUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect {
                    submitState(it)
                }
        }
    }
}

