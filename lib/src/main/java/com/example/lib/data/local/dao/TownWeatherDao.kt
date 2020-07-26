package com.example.lib.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lib.data.entities.TownWeather

/**
 * Created by zaineb on 25/07/2020
 */
@Dao
interface TownWeatherDao {
    @Query("SELECT * FROM weather_town_info WHERE lat=:lat AND lon=:lon")
    suspend fun findAll(lat: Long, lon: Long): TownWeather

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(towns: TownWeather)
}