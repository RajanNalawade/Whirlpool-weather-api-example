package com.example.weatherdata.data_layer.remote

import com.example.weatherdata.data_layer.remote.models.WeatherApiResponce
import io.reactivex.rxjava3.core.Observable

interface WeatherApiHelper {

    fun getWeatherForecast(place: String): Observable<WeatherApiResponce>
}