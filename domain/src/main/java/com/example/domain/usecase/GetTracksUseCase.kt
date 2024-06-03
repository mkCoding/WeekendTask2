package com.example.domain.usecase

import com.example.domain.entity.Track
import com.example.domain.repo.TrackRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTracksUseCase(
    configuration: UseCase.Configuration,
    private val repo: TrackRepository):
    UseCase<GetTracksUseCase.Request, GetTracksUseCase.Response>(configuration){

    override fun process(request: Request): Flow<Response> =
        repo.getTracks()
            .map {
                Response(it)
            }

    data object Request : UseCase.Request
    data class Response(val tracks: List<Track?>?) : UseCase.Response

    }