package com.example.library.ui.theme.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.library.ui.theme.Screens.AboutScreen.AboutScreen
import com.example.library.ui.theme.Screens.HomeScreen.HomeScreen
import com.example.library.ui.theme.Screens.LoginScreen.LoginScreen
import com.example.library.ui.theme.Screens.ProductScreen.AddProductsScreen

//import com.example.library.ui.theme.Screens.ProductScreen.bookPage
import com.example.library.ui.theme.Screens.ProductScreen.UpdateProductsScreen
//import com.example.library.ui.theme.Screens.ProductScreen.AddProduct
import com.example.library.ui.theme.Screens.ProductScreen.ViewProductsScreen
import com.example.library.ui.theme.Screens.ProductScreen.ViewUploadsScreen
import com.example.library.ui.theme.Screens.RegisterScreen.RegistrationScreen


@Composable
fun AppNavHost(modifier: Modifier=Modifier,
               navController: NavHostController= rememberNavController(),
               startDestination:String = ROUTE_REGISTER){
    NavHost(navController = navController,
        modifier = modifier,
        startDestination = startDestination ){
        composable(ROUTE_HOME){
            HomeScreen(navController )

        }
        composable(ROUTE_ABOUT){
            AboutScreen(navController )
        }
        composable(ROUTE_REGISTER){
         RegistrationScreen(navController)

        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_ADD_PRODUCT){
          AddProductsScreen(navController)

        }
        composable(ROUTE_UPDATE_PRODUCT+"/{id}"){passedData->
          UpdateProductsScreen(navController,passedData.arguments?.getString("id")!! )
        }
        composable(ROUTE_VIEW_PRODUCT){
            ViewProductsScreen(navController )

        }
        composable(ROUTE_VIEW_UPLOAD){
            ViewUploadsScreen(navController )
        }

        }
    }



















