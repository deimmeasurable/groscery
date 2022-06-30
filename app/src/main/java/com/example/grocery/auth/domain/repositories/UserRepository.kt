package com.example.grocery.auth.domain.repositories

import com.example.grocery.auth.request.LoginRequest
import com.example.grocery.auth.response.LoginResponse

interface UserRepository {
    suspend fun login(request: LoginRequest): LoginResponse
}