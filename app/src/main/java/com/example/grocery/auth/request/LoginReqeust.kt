package com.example.grocery.auth.request

data class LoginRequest(
    val email: String,
    val password: String
)