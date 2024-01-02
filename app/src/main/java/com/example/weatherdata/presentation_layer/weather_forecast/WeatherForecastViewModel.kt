package com.example.weatherdata.presentation_layer.weather_forecast

import androidx.lifecycle.ViewModel
import com.example.weatherdata.domain_layer.GetForecastUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WeatherForecastViewModel @Inject constructor(private val useCase: GetForecastUseCase) :
    ViewModel() {

    private val weeklyWeather = useCase("Pune")
    val mWeeklyWeather = weeklyWeather
}