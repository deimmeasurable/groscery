package com.example.grocery.auth.domain.repositories

import com.example.grocery.auth.request.LoginRequest
import com.example.grocery.auth.response.Api
import com.example.grocery.auth.response.LoginResponse

class UserRepositoryImpl (
    private val api: Api
): UserRepository {
    override suspend fun login(request: LoginRequest): LoginResponse {
        TODO("Not yet implemented")
    }
}