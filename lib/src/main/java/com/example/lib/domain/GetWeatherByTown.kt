package com.example.lib.domain

import com.example.lib.common.APPID
import com.example.lib.common.EXCLUDE
import com.example.lib.common.LAN
import com.example.lib.common.UNITS
import com.example.lib.data.remote.response.model.WeatherTownResponse
import com.example.lib.data.repository.WeatherRepository
import javax.inject.Inject

/**
 * Created by zaineb on 24/07/2020
 */
class GetWeatherByTown @Inject constructor(private val weatherRepository: WeatherRepository) {

    suspend fun execute(
        lat: Double,
        lon: Double
    ): WeatherTownResponse {
        return weatherRepository.getWeatherTown(
            lat,
            lon,
            EXCLUDE,
            APPID,
            UNITS,
            LAN
        )
    }
}
