package com.example.retrofit2_study

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

data class UrlInfo(
    @SerializedName("body")
    val body : JsonObject
)
