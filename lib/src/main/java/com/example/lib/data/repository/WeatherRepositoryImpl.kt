package com.example.lib.data.repository

import com.example.lib.data.entities.TownWeather
import com.example.lib.data.local.dataSource.WeatherLocal
import com.example.lib.data.remote.dataSource.WeatherRemote
import com.example.lib.data.remote.response.model.WeatherTownResponse
import com.example.lib.data.entities.Town

/**
 * Created by zaineb on 23/07/2020
 */
class WeatherRepositoryImpl(
    private val weatherRemote: WeatherRemote,
    private val weatherLocal: WeatherLocal
) : WeatherRepository {

    override suspend fun getWeatherTown(
        lat: Double,
        lon: Double,
        exclude: String,
        appid: String,
        units: String,
        lang: String
    ): WeatherTownResponse = weatherRemote.getWeatherTownAsync(
        lat,
        lon,
        exclude,
        appid,
        units,
        lang
    )

    override suspend fun getWeatherInfoFromLocal(lat: Double, lon: Double): TownWeather? =
        weatherLocal.findAllTownWeather(lat, lon)

    override suspend fun addWeatherInfoToLocal(townWeather: TownWeather) =
        weatherLocal.addTownWeather(townWeather)

    override suspend fun addTown(town: Town) {
        weatherLocal.addTown(town)
    }

    override suspend fun getFavoritesTownsFromLocal(): List<Town> = weatherLocal.findAllFavoritesTowns()

}

