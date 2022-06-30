package com.example.grocery.auth.usecases.auth

import com.example.grocery.auth.events.AuthEvent

data class AuthenticationUseCases(
    val login: AuthEvent.Login
)