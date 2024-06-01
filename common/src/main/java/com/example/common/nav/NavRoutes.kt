package com.example.common.nav

import androidx.navigation.NamedNavArgument

class NavRoutes {

    sealed class NavRoutes(
        val route: String,
        val arguments: List<NamedNavArgument> = emptyList()
    ) {
        data object Dasboard : NavRoutes(ROUTE_DASHBOARD)
    }

    data object Login : NavRoutes(ROUTE_LOGIN)
    data object SignUp : NavRoutes(ROUTE_SIGN_UP)
    data object Dashboard:NavRoutes(ROUTE_DASHBOARD)
    data object Search:NavRoutes(ROUTE_SEARCH)




    companion object {
        const val ROUTE_LOGIN = "login"
        const val ROUTE_SIGN_UP = "signup"
        const val ROUTE_DASHBOARD="dashboard"
        const val ROUTE_SEARCH = "search"

    }
}