package com.example.grocery.auth


import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.grocery.auth.navigation.navHost.AuthenticationNavigationHost
import com.example.grocery.auth.viewmodels.AuthViewModel

@Composable
fun AuthenticationWrapper(
    viewModel: AuthViewModel
){
    val navController = rememberNavController()
    AuthenticationNavigationHost(navController = navController,
        authViewModel = viewModel)
}