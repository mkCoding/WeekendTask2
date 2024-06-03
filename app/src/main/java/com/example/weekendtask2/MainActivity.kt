package com.example.weekendtask2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.common.nav.NavRoutes
import com.example.weekendtask2.ui.compose.track.list.TrackListScreen
import com.example.weekendtask2.ui.compose.login.LoginScreen
import com.example.weekendtask2.ui.compose.login.SignUpScreen
import com.example.weekendtask2.ui.compose.search.SearchScreen
import com.example.weekendtask2.ui.theme.WeekendTask2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            val navController = rememberNavController()
//            App(navController)

            // Check if user is logged in or not
//            val isLoggedIn = checkUserLoggedIn()
//            if (isLoggedIn) {
//                // If user is logged in, show main content
//                // Example: setContent { MainContent() }
//            } else {
//                // If user is not logged in, show login screen
//                setContent { LoginScreen() }
//            }


            WeekendTask2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MyApp(navController, true)
                }
            }

        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyApp(navController: NavHostController, isFirstRun:Boolean) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val bottomBarState = remember { mutableStateOf(true) }

    when (navBackStackEntry?.destination?.route) {
        NavRoutes.Tracks.route,
        NavRoutes.Search.route -> {
            bottomBarState.value = true
        }

        else -> {
            bottomBarState.value = false
        }
    }



    val context = LocalContext.current

    // Check if it's the first run
//    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
//    val isFirstRun = sharedPreferences.getBoolean("isFirstRun", true)
//

    //scaffold the bottom nav bar
    Scaffold(
        // top bar
        bottomBar = {
            if (bottomBarState.value) {
                BottomAppBar(navController = navController)
            }
        }
    ) { innerPadding ->
    NavHost(
        navController = navController,
        startDestination = if (isFirstRun) NavRoutes.Login.route else NavRoutes.Tracks.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(NavRoutes.Login.route) {
            // Navigate to LoginScreen if it's the first run
            LoginScreen(navController = navController)
        }
        composable(NavRoutes.SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(NavRoutes.Tracks.route) {
            // Navigate to Dashboard if it's not the first run
            TrackListScreen(navController = navController)
        }
        composable(NavRoutes.Search.route) {
            SearchScreen(navController = navController)
        }
    }
    }
}


//Display Bottom App Bar with required categories

@Composable
fun BottomAppBar(navController: NavHostController) {
    var showSignOutDialog by remember { mutableStateOf(false) }

    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Color.Black
    ) {
        //Dashboard Item
        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Dashboard"
                )
            },
            selected = navController.currentDestination?.route == NavRoutes.Tracks.route,
            onClick = {
                navController.navigate(NavRoutes.Tracks.route) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        //Search Item
        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search"
                )
            },
            selected = navController.currentDestination?.route == NavRoutes.Search.route,
            onClick = {
                navController.navigate(NavRoutes.Search.route) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        )
        //SignOut
        BottomNavigationItem(
            icon = {
                Icon(
                    Icons.Filled.ExitToApp,
                    contentDescription = "Sign Out"
                )
            },
            selected = false,
            onClick = { showSignOutDialog = true }
        )
    }


    if (showSignOutDialog) {
        AlertDialog(
            onDismissRequest = { showSignOutDialog = false },
            title = { Text(text = "Sign Out") },
            text = { Text(text = "Are you sure you want to Sign Out?") },
            confirmButton = {
                OutlinedButton(
                    onClick = {
                        showSignOutDialog = false
                        navController.navigate(NavRoutes.Login.route) {
                            popUpTo(NavRoutes.Tracks.route) { inclusive = true }
                        }

                    },
                    modifier = Modifier
                        .width(80.dp)
                        .height(48.dp)
                        .padding(vertical = 1.5.dp),
                    border = BorderStroke(1.dp, Color.Black),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.Black,
                        containerColor = Color.Transparent
                    )
                ) {
                    Text("Yes")
                }
            },
            dismissButton = {
                TextButton(onClick = { showSignOutDialog = false }) {
                    Text(
                        text = "No",
                        color = Color.Black,
                        modifier = Modifier
                            .height(48.dp)
                            .padding(vertical = 1.5.dp),
                    )
                }
            }
        )
    }
}


 fun checkUserLoggedIn(): Boolean {
    // Implement logic to check if user is logged in
    // Example: return true if user is logged in, false otherwise
    return false
}





@Preview
@Composable
fun MyAppPreview() {


    WeekendTask2Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            // For preview, assume it's the first run
            val navController = rememberNavController()
            val isFirstRun = true
            MyApp(navController, isFirstRun = true)
        }
    }
}
