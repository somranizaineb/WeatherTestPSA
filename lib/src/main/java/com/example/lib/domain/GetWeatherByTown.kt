package com.example.lib.domain

import com.example.lib.data.remote.response.model.WeatherTownResponse
import com.example.lib.data.repository.WeatherRepository
import javax.inject.Inject

/**
 * Created by zaineb on 24/07/2020
 */
class GetWeatherByTown @Inject constructor(private val weatherRepository: WeatherRepository) {

    suspend fun execute(
        lat: Long,
        lon: Long
    ): WeatherTownResponse {
        return weatherRepository.getWeatherTown(
            lat,
            lon,
            "minutely,hourly",
            "39df4d2213f72ea35fcfcf89100d61ab",
            "metric",
            "fr"
        )
    }
}
