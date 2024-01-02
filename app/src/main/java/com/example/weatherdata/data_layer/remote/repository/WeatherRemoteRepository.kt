package com.example.weatherdata.data_layer.remote.repository

import com.example.weatherdata.data_layer.remote.WeatherApiHelper
import com.example.weatherdata.data_layer.remote.models.WeatherApiResponce
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class WeatherRemoteRepository @Inject constructor(private val weatherApiHelper: WeatherApiHelper) {
    fun getWeatherForecast(place: String): Observable<WeatherApiResponce> =
        weatherApiHelper.getWeatherForecast(place)
}