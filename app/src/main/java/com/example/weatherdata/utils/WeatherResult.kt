package com.example.weatherdata.utils

sealed class WeatherResult<T>(val data: T? = null, val message: String? = null) {

    data class Success<T>(val output: T) : WeatherResult<T>(output)

    data class Error<T>(val output: T? = null, val errorMessage: String? = null) :
        WeatherResult<T>(output, errorMessage)

    class Loading<T> : WeatherResult<T>()
}