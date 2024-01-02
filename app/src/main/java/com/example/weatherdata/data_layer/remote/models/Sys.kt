package com.example.weatherdata.data_layer.remote.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Sys(
    @SerializedName("pod")
    val pod: String // n
)