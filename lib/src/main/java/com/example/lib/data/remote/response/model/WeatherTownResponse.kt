package com.example.lib.data.remote.response.model

import com.squareup.moshi.Json

/**
 * Created by zaineb on 24/07/2020
 */

class WeatherTownResponse {
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
        "WeatherTownResponse(" +
                "\nlat=$lat," +
                "\n\n\nlon=$lon," +
                "\n\n\ntimezone=$timezone," +
                "\n\n\ntimezoneOffset=$timezoneOffset," +
                "\n\n\ncurrent=$current," +
                "\n\n\ndaily=$daily)"
}