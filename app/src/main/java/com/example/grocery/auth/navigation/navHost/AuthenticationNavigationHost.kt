package com.example.grocery.auth.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.grocery.auth.navigation.destination.Destination
import com.example.grocery.auth.screens.Register
import com.example.grocery.auth.usecases.auth.Login
import com.example.grocery.auth.viewmodels.AuthViewModel

@Composable
fun AuthenticationNavigationHost(
    navController: NavHostController,
    authViewModel: AuthViewModel
){

    NavHost(navController = navController, startDestination = Destination.LoginDestination.route  ){

        composable(route= Destination.LoginDestination.route){
            Login(navController = navController,
                authViewModel= authViewModel
            )
        }

        composable(route= Destination.SignupDestination.route){
            Register(navController = navController)
        }
    }
}