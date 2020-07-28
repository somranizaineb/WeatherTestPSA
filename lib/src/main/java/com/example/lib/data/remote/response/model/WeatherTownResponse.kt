package com.example.lib.data.remote.response.model

import com.example.lib.data.entities.TownWeather
import com.google.gson.Gson
import com.squareup.moshi.Json

/**
 * Created by zaineb on 24/07/2020
 */

class WeatherTownResponse {
    @Json(name = "lat")
    var lat: Double = 0.0

    @Json(name = "lon")
    var lon: Double = 0.0

    @Json(name = "timezone")
    var timezone: String? = null

    @Json(name = "current")
    var current: Current? = null

    @Json(name = "daily")
    var daily: MutableList<Daily>? = null

    override fun toString(): String =
        "WeatherTownResponse(lat=$lat, lon=$lon, current=$current, daily=$daily)"
}

fun WeatherTownResponse.townWeatherBuilder(): TownWeather {
    val townWeather = TownWeather()
    townWeather.lon = this.lon
    townWeather.lat = this.lat
    townWeather.timezone = this.timezone
    townWeather.current = Gson().toJson(this.current)
    townWeather.daily = Gson().toJson(this.daily)
    return townWeather
}
