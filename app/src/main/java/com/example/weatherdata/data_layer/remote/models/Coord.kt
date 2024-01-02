package com.example.weatherdata.data_layer.remote.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Coord(
    @SerializedName("lat")
    val lat: Double, // 18.5196
    @SerializedName("lon")
    val lon: Double // 73.8553
)