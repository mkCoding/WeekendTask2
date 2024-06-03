package com.example.domain.usecase

import com.example.domain.entity.Track
import com.example.domain.repo.TrackRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTracksByIdUseCase(
    configuration: UseCase.Configuration,
    private val repo: TrackRepository
): UseCase<GetTracksByIdUseCase.Request, GetTracksByIdUseCase.Response>(configuration){
    override fun process(request: Request): Flow<Response> =
        repo.getTrack(request.trackId)
            .map {
                Response(it)
            }

    data class Request(val trackId: Int?) : UseCase.Request
    data class Response(val track: Track?) : UseCase.Response
}