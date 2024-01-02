package com.example.weatherdata.data_layer.remote.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Main(
    @SerializedName("feels_like")
    val feelsLike: Double, // 295.58
    @SerializedName("grnd_level")
    val grndLevel: Int, // 954
    @SerializedName("humidity")
    val humidity: Int, // 33
    @SerializedName("pressure")
    val pressure: Int, // 1017
    @SerializedName("sea_level")
    val seaLevel: Int, // 1017
    @SerializedName("temp")
    val temp: Double, // 296.34
    @SerializedName("temp_kf")
    val tempKf: Double, // 1.22
    @SerializedName("temp_max")
    val tempMax: Double, // 296.34
    @SerializedName("temp_min")
    val tempMin: Double // 296.34
)