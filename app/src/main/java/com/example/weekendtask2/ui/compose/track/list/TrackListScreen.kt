package com.example.weekendtask2.ui.compose.track.list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TrackListScreen(navController: NavHostController){

        Text(
            text = "Dashboard",
            style = TextStyle(fontSize = 30.sp)
        )

}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview(){
    val navController = rememberNavController()
    TrackListScreen(navController = navController)
}


