package com.example.myapplication.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthEndpoints {


    @POST("account/login")
    fun setLogin(@Body loginData: LoginData): Call<LoginResponse>

    class LoginData(var email: String, var password: String)


}
