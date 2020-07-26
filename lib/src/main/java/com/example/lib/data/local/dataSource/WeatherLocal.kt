package com.example.lib.data.local.dataSource

import com.example.lib.data.entities.TownWeather
import com.example.lib.data.local.AppDatabase
import com.example.lib.data.entities.Town
import javax.inject.Inject

/**
 * Created by zaineb on 23/07/2020
 */
class WeatherLocal @Inject constructor() {
    @Inject
    lateinit var appDatabase: AppDatabase

    suspend fun findAllTownWeather(lat: Long, lon: Long): TownWeather =
        appDatabase.townWeatherDao.findAll(lat, lon)

    suspend fun addTownWeather(townWeather: TownWeather) {
        appDatabase.townWeatherDao.add(townWeather)
    }

    suspend fun addTown(town: Town) {
        appDatabase.townDao.insert(town)
    }

    suspend fun findAllFavoritesTowns() = appDatabase.townDao.findAll()

}