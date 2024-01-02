package com.example.weatherdata.data_layer.remote

import com.example.weatherdata.data_layer.remote.models.WeatherApiResponce
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class WeatherApiHelperImpl @Inject constructor(private val apiService: WeatherApiService) :
    WeatherApiHelper {
    override fun getWeatherForecast(place: String): Observable<WeatherApiResponce> {
        return apiService.getWeatherForecast(place)
    }


}