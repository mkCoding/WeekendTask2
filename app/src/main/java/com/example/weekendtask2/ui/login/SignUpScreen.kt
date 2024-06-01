package com.example.weekendtask2.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.weekendtask2.R

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen(navController: NavHostController){
    val context = LocalContext.current

    /*
    initialize keyboardController since user will be entering text
    for email and pass
     */
    val keyboardController = LocalSoftwareKeyboardController.current

    // State for holding email and password
    //these values will allow me to grab the info that the user has entered

    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }


    /*
    Column to stack Image, EditText and Button elements vertically
     */
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        //Image Element to display the music note
        Text(
            text = "Sign Up",
            fontSize = 40.sp, // Adjust the font size as needed
            color = Color.Black, // Customize the text color
            textAlign = TextAlign.Center, // Align the text to the center
            modifier = Modifier
                .padding(vertical = 16.dp) // Add some vertical padding for spacing
                .fillMaxWidth()
            , // Take up the full width available
            style = MaterialTheme.typography.headlineLarge,
            // You can customize the text style further if needed
        )

        //Add some space
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = firstName.value,
            onValueChange = { emailState.value = it },
            label = { Text("Firstname") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = lastName.value,
            onValueChange = { emailState.value = it },
            label = { Text("Lastname") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Add EditText for Email
        TextField(
            value = emailState.value,
            onValueChange = { emailState.value = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        //Add some space
        Spacer(modifier = Modifier.height(8.dp))

        //Add Edit text for password
        TextField(
            value = passwordState.value,
            onValueChange = { passwordState.value = it },
            label = { Text("Password") },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
            }),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        //Add confirm password
        TextField(
            value = confirmPassword.value,
            onValueChange = {passwordState.value = it},
            label = { Text(text = ("Confirm password"))},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                keyboardController?.hide()
            }),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))



        Button(
            onClick = {
                // Handle login button click here
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Sign Up")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun signUpScreenPreview(){
    val navController = rememberNavController()
    SignUpScreen(navController = navController)
}