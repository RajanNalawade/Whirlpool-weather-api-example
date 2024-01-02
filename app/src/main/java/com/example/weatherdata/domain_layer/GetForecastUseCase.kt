package com.example.weatherdata.domain_layer

import com.example.weatherdata.data_layer.remote.repository.WeatherRemoteRepository
import javax.inject.Inject

class GetForecastUseCase @Inject constructor(private val repository: WeatherRemoteRepository) {

    operator fun invoke(place: String) = repository.getWeatherForecast(place)
}