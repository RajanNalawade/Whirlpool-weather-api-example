package com.example.weatherdata.data_layer.remote.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Clouds(
    @SerializedName("all")
    val all: Int // 3
)