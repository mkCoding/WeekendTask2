package com.example.common.nav

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import com.example.data.remote.network.ArtistModelX

class NavRoutes {

    sealed class NavRoutes(
        val route: String,
        val arguments: List<NamedNavArgument> = emptyList()
    ) {
        data object Tracks : NavRoutes(ROUTE_TRACKS)


        //Route to Tracks List

        fun routeForTracks(input: TrackInput) =
            "tracks/${input.trackId}?" +
                    "${ARG_TRACK_NAME}=${input.trackName}&" +
                    "${ARG_ARTIST}=${input.artist?.get(0)?.name}&" + //extract name from artist list
                    "${ARG_TRACK_NAME}=${input.trackName}&" +
                    "${ARG_DURATION}=${input.duration}&" +
                    "${ARG_EXPLICIT}=${input.explicit}"

        //"movies/${input.movieId}?${ARG_ORIGIN_TITLE}=${input.originalTitle}&${ARG_IMAGE}=${input.posterPath}&${ARG_OVERVIEW}=${input.overview}&${ARG_RELEASE_DATE}=${input.releaseDate}"


        //route to Track Details
        fun fromEntry(entry: NavBackStackEntry): TrackInput {
            val artistsArray: Array<ArtistModelX>? = entry.arguments?.getParcelableArray(ARG_ARTIST)?.mapNotNull { it as? ArtistModelX }?.toTypedArray()
            //val album: AlbumModel? = entry.arguments?.getParcelable(ARG_ALBUM) as? AlbumModel
            //album ?: AlbumModel(),

            return TrackInput(
                entry.arguments?.getInt(ARG_TRACK_ID) ?: 0,
                artistsArray?.toList() ?: emptyList(),
                entry.arguments?.getString(ARG_TRACK_NAME) ?: "",
                entry.arguments?.getInt(ARG_DURATION)?:0,
                entry.arguments?.getBoolean(ARG_EXPLICIT) ?: false
            )
        }
    }




    data object Login : NavRoutes(ROUTE_LOGIN)
    data object SignUp : NavRoutes(ROUTE_SIGN_UP)
    data object Tracks:NavRoutes(ROUTE_TRACKS)
    data object Search:NavRoutes(ROUTE_SEARCH)




    companion object {
        //Routes
        const val ROUTE_LOGIN = "login"
        const val ROUTE_SIGN_UP = "signup"
        const val ROUTE_TRACKS="tracks"
        const val ROUTE_SEARCH = "search"

        //Arguments
        const val ARG_TRACK_ID = "trackId"
        const val ARG_ARTIST = "artist"
        const val ARG_ALBUM="album"
        const val ARG_TRACK_NAME = "trackName"
        const val ARG_DURATION = "duration"
        const val ARG_RELEASE_DATE="releaseDate"
        const val ARG_EXPLICIT="explicit"

    }



}