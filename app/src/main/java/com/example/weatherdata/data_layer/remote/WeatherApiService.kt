package com.example.weatherdata.data_layer.remote

import com.example.weatherdata.data_layer.remote.models.WeatherApiResponce
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {

    @GET("forecast")
    fun getWeatherForecast(@Query("q") place: String): Observable<WeatherApiResponce>
}