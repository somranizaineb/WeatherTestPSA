package com.example.lib.data.repository

import com.example.lib.data.remote.response.model.WeatherTownResponse

/**
 * Created by zaineb on 23/07/2020
 */
interface WeatherRepository {

    suspend fun getWeatherTown(
        lat: Long,
        lon: Long,
        exclude: String,
        appid: String
    ): WeatherTownResponse
}