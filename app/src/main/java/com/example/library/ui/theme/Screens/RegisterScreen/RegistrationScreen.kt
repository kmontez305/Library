package com.example.library.ui.theme.Screens.RegisterScreen

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.library.R
import com.example.library.ui.theme.data.AuthViewModel
import com.example.library.ui.theme.navigation.ROUTE_HOME
import com.example.library.ui.theme.navigation.ROUTE_LOGIN

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(navController:NavHostController) {
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current

Box {
 androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.luri), contentDescription = "")
}
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

            ){

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center)

            {
                val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.json))
                val progress by animateLottieCompositionAsState(composition)
                LottieAnimation(
                    composition, progress,
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.White))
            }
    Text(text = "Register here",
        color = Color.Cyan,
        fontFamily = FontFamily.Cursive,
        fontSize = 30.sp)
    Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") }
            )
            OutlinedTextField(value =confirmpass , onValueChange = {
                confirmpass=it},
                label = { Text(text = "Enter Confirm Pass") },

                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))


            Button(onClick = {
                val myregister = AuthViewModel(navController, context)
                myregister.signup(email.text.trim(), password.text.trim(), confirmpass.text.trim())
                navController.navigate(ROUTE_HOME)
            }, modifier = Modifier.fillMaxWidth()){Text(text = "Register")}





//                Spacer(modifier = Modifier.height(16.dp))
//                OutlinedButton(onClick = {
//                    navController.navigate(ROUTE_HOME)
//                }, modifier = Modifier.fillMaxWidth()) {
//                    Text("Register")
//                }

                OutlinedButton(onClick = {
                    navController.navigate(ROUTE_LOGIN)
                }, modifier = Modifier.fillMaxWidth()) {
                    Text("Have an Account?Click to Login")
                }
            }
}






@Preview
@Composable
fun RegistrationScreenPreview(){
    RegistrationScreen(rememberNavController())
}
