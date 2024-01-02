package com.example.weatherdata.data_layer.remote.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Weather(
    @SerializedName("description")
    val description: String, // clear sky
    @SerializedName("icon")
    val icon: String, // 01n
    @SerializedName("id")
    val id: Int, // 800
    @SerializedName("main")
    val main: String // Clear
)