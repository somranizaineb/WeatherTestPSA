package com.example.lib.data.repository

import com.example.lib.data.entities.TownWeather
import com.example.lib.data.remote.response.model.WeatherTownResponse
import com.example.lib.data.entities.Town

/**
 * Created by zaineb on 23/07/2020
 */
interface WeatherRepository {


    suspend fun getWeatherTown(
        lat: Double,
        lon: Double,
        exclude: String,
        appid: String,
        units: String,
        lang : String
    ): WeatherTownResponse


    suspend fun getWeatherInfoFromLocal(
        lat: Double,
        lon: Double
    ): TownWeather?

    suspend fun addWeatherInfoToLocal(townWeather: TownWeather)

    suspend fun addTown(town: Town)

    suspend fun getFavoritesTownsFromLocal(
    ): List<Town>
}