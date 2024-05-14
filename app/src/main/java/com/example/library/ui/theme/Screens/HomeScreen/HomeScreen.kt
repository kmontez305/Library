package com.example.library.ui.theme.Screens.HomeScreen

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import com.example.library.R
import com.example.library.ui.theme.navigation.ROUTE_ADD_PRODUCT
import com.example.library.ui.theme.navigation.ROUTE_VIEW_PRODUCT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
Column {
    AppBars(rememberNavController())

}





}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBars(navController: NavHostController) {
Box {
    Box (modifier = Modifier.fillMaxSize()){
        androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.luri), contentDescription = "")

    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("LIBRARY")
                }


            )

            Row(
                modifier = Modifier
                    .padding()
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Right,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {   }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Icon 1",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.width(14.dp))
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "my profile",
                        tint = Color.Black, modifier = Modifier.size(24.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                IconButton(onClick = {   }) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "my profile",
                        tint = Color.Black, modifier = Modifier.size(24.dp)
                    )
                }



            }

        },

        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }

    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            Button(onClick = {

                navController.navigate(ROUTE_ADD_PRODUCT)
            },modifier = Modifier.fillMaxWidth()) {
                Text(text = "Add Product")
            }
            Spacer(modifier = Modifier.height(100.dp))

            Button(onClick = {

                navController.navigate(ROUTE_VIEW_PRODUCT)
            },modifier = Modifier.fillMaxWidth()) {
                Text(text = "View Product")
            }
            val mContext = LocalContext.current

            Button(onClick = {
                val callIntent= Intent(Intent.ACTION_DIAL)
                callIntent.data="tel:0111623090".toUri()
                mContext.startActivity(callIntent)
            },shape = RoundedCornerShape(3.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)) {
                Text(text = "CALL US",) }
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                val smsIntent= Intent(Intent.ACTION_SENDTO)
                smsIntent.data="smsto:0111623090".toUri()
                smsIntent.putExtra("sms_body","")
                mContext.startActivity(smsIntent)
            },shape = RoundedCornerShape(3.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                colors = ButtonDefaults.buttonColors(Color.Black)) {
                Text(text = "TEXT US",) }


        }
    }



}

}

private fun Nothing?.navigate(routeViewProduct: String) {
    TODO("Not yet implemented")
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview(){
HomeScreen(rememberNavController())
}