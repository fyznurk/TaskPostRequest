package com.example.myapplication.remote

import okhttp3.Interceptor
import okhttp3.Response
import java.net.HttpURLConnection

class ApiInterceptor () : Interceptor {

    companion object {
        var authToken: String? = null
        var socialToken: String? = null
    }

    override fun intercept(chain: Interceptor.Chain): Response {

        val rqBuilder = chain.request().newBuilder()
        rqBuilder.addHeader("Accept", "application/json")

      /*  val response=chain.proceed(rqBuilder.build())

        return response.newBuilder().code(HttpURLConnection.HTTP_SEE_OTHER).build()*/
        return chain.proceed(rqBuilder.build())
    }
}