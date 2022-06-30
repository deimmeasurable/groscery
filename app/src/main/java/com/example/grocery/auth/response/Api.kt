package com.example.grocery.auth.response
import com.example.grocery.auth.request.LoginRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("api/v1/auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}