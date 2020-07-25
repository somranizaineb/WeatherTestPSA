package com.example.lib.data.remote.response.model

import com.squareup.moshi.Json

/**
 * Created by zaineb on 24/07/2020
 */
class WeatherResponse {
    @Json(name = "lat")
    var lat: Int? = null

    @Json(name = "lon")
    var lon: Int? = null

    @Json(name = "timezone")
    var timezone: String? = null

    @Json(name = "timezone_offset")
    var timezoneOffset: Int? = null

    @Json(name = "current")
    var current: Current? = null

    @Json(name = "daily")
    var daily: List<Daily>? = null
    override fun toString(): String =
        "WeatherResponse(lat=$lat, lon=$lon, timezone=$timezone, timezoneOffset=$timezoneOffset, current=$current, daily=$daily)"
}

