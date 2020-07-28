package com.example.lib.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lib.data.entities.TownWeather
import com.example.lib.data.local.AppDatabase.Companion.VERSION
import com.example.lib.data.local.dao.TownWeatherDao
import com.example.lib.data.entities.Town
import com.example.lib.data.local.dao.TownDao

/**
 * Created by zaineb on 23/07/2020
 */
@Database(entities = [Town::class,TownWeather::class], version = VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val townWeatherDao: TownWeatherDao
    abstract val townDao: TownDao

    companion object {
        const val VERSION = 1
        const val NAME = "weather.db"
    }

}