package com.example.weatherdata.data_layer.remote.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class WeatherItems(
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("dt")
    val dt: Int, // 1703689200
    @SerializedName("dt_txt")
    val dtTxt: String, // 2023-12-27 15:00:00
    @SerializedName("main")
    val main: Main,
    @SerializedName("pop")
    val pop: Int, // 0
    @SerializedName("sys")
    val sys: Sys,
    @SerializedName("visibility")
    val visibility: Int, // 10000
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("wind")
    val wind: Wind
)