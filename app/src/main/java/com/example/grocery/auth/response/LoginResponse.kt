package com.example.grocery.auth.response

import com.example.grocery.auth.remote.models.User

data class LoginResponse(
    val status: String,
    val token: String,
    val data: User
)