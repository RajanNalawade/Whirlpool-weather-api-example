package com.example.weatherdata.data_layer.remote.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Wind(
    @SerializedName("deg")
    val deg: Int, // 118
    @SerializedName("gust")
    val gust: Double, // 2.55
    @SerializedName("speed")
    val speed: Double // 2.42
)