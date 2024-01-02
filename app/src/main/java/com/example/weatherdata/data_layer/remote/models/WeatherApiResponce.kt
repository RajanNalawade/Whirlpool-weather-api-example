package com.example.weatherdata.data_layer.remote.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class WeatherApiResponce(
    @SerializedName("city")
    val city: City,
    @SerializedName("cnt")
    val cnt: Int, // 40
    @SerializedName("cod")
    val cod: String, // 200
    @SerializedName("list")
    val list: List<WeatherItems>,
    @SerializedName("message")
    val message: Int // 0
)