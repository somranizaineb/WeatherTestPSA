package com.example.lib.domain

import com.example.lib.data.entities.TownWeather
import com.example.lib.data.repository.WeatherRepository
import javax.inject.Inject

/**
 * Created by zaineb on 26/07/2020
 */
class AddWeatherInfoToLocal @Inject constructor(private val weatherRepository: WeatherRepository) {
    suspend fun execute(townWeather: TownWeather) =
        weatherRepository.addWeatherInfoToLocal(townWeather)
}