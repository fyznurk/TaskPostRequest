package com.example.myapplication.remote

data class LoginResponse(
    val message: String,
    val data: ResponseData
)

data class ResponseData(
    val accessToken: String
)
