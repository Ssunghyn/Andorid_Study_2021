package com.example.retrofit2_study

import retrofit2.Call
import retrofit2.http.GET

interface UrlAPI {
    @GET("/prod/version")
    fun getUrlInfo(): Call<UrlInfo>
}