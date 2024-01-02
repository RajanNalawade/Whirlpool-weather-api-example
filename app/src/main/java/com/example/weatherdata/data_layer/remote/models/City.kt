package com.example.weatherdata.data_layer.remote.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class City(
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("country")
    val country: String, // IN
    @SerializedName("id")
    val id: Int, // 1259229
    @SerializedName("name")
    val name: String, // Pune
    @SerializedName("population")
    val population: Int, // 9999
    @SerializedName("sunrise")
    val sunrise: Int, // 1703640878
    @SerializedName("sunset")
    val sunset: Int, // 1703680549
    @SerializedName("timezone")
    val timezone: Int // 19800
)