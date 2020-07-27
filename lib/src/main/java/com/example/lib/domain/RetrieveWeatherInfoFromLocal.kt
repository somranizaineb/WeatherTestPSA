package com.example.lib.domain

import com.example.lib.data.repository.WeatherRepository
import javax.inject.Inject

/**
 * Created by zaineb on 26/07/2020
 */
class RetrieveWeatherInfoFromLocal @Inject constructor(private val weatherRepository: WeatherRepository) {
    suspend fun execute(lat: Double, lon: Double) =
        weatherRepository.getWeatherInfoFromLocal(lat, lon)
}