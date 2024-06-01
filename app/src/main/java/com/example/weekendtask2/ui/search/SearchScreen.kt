package com.example.weekendtask2.ui.search

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    var searchText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        Text(
            text = "Search An Artist",
            style = TextStyle(fontSize = 30.sp)
        )
        Spacer(modifier = Modifier.height(16.dp))


        SearchBar(
            searchText = searchText,
            onSearchTextChanged = { newText ->
                searchText = newText
                // Perform search operation or any other action here
            }
        )



    }
}

@Composable
fun SearchBar(
    searchText: String,
    onSearchTextChanged: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {

        val context = LocalContext.current


        OutlinedTextField(
            modifier = Modifier.width(350.dp)
                .padding(start = 40.dp),
            value = searchText,
            onValueChange = { onSearchTextChanged(it) },
            placeholder = { Text("Search...") }
        )

        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            modifier = Modifier.padding(8.dp)
                .clickable{
                    Toast.makeText(context,"You searched $searchText",Toast.LENGTH_LONG).show()
                }
        )
    }
}

//@Preview
//@Composable
//fun SearchBarPreview() {
//    SearchBar(searchText = "", onSearchTextChanged = {})
//}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview(){
    val navController = rememberNavController()
    SearchScreen(navController = navController)
}