package com.example.lib.data.repository

import com.example.lib.data.remote.dataSource.WeatherRemote
import com.example.lib.data.remote.response.model.WeatherTownResponse

/**
 * Created by zaineb on 23/07/2020
 */
class WeatherRepositoryImpl(private val weatherRemote: WeatherRemote) : WeatherRepository {

    override suspend fun getWeatherTown(
        lat: Long,
        lon: Long,
        exclude: String,
        appid: String
    ): WeatherTownResponse = weatherRemote.getWeatherTownAsync(
        lat,
        lon,
        exclude,
        appid
    )
}
