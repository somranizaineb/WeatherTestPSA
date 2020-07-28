package com.example.lib.data.entities

import androidx.room.Entity
import com.example.lib.data.remote.response.model.Current
import com.example.lib.data.remote.response.model.Daily
import com.example.lib.data.remote.response.model.WeatherTownResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Created by zaineb on 26/07/2020
 */
@Entity(
    tableName = "weather_town_info",
    primaryKeys = ["lat", "lon"]
)
class TownWeather {
    var lat: Double = 0.0

    var lon: Double = 0.0

    var timezone: String? = null

    var current: String? = null

    var daily: String? = null

    override fun toString(): String =
        "WeatherTownResponse(lat=$lat, lon=$lon, current=$current, daily=$daily)"
}

fun TownWeather.townWeatherBuilder(): WeatherTownResponse {
    val weatherTownResponse = WeatherTownResponse()
    weatherTownResponse.lon = lon
    weatherTownResponse.lat = lat
    weatherTownResponse.timezone = this.timezone
    weatherTownResponse.current = Gson().fromJson(this.current, Current::class.java)
    weatherTownResponse.daily =
        Gson().fromJson(this.daily, object : TypeToken<List<Daily>>() {}.type)
    return weatherTownResponse
}