package com.example.lib.domain

import com.example.lib.data.remote.response.model.WeatherTownResponse
import com.example.lib.data.repository.WeatherRepository
import javax.inject.Inject

/**
 * Created by zaineb on 24/07/2020
 */
class GetWeatherByTown @Inject constructor(private val weatherRepository: WeatherRepository) {

    suspend fun execute(): WeatherTownResponse {
        return weatherRepository.getWeatherTown(
            33.441792.toLong(),
            (-94.037689).toLong(),
            "minutely,hourly",
            "39df4d2213f72ea35fcfcf89100d61ab"
        )
    }
}
