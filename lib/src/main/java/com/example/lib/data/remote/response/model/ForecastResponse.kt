package com.example.lib.data.remote.response.model

import com.squareup.moshi.Json

/**
 * Created by zaineb on 24/07/2020
 */
class ForecastResponse(
    val dt: Long?,
    val temp: Double?,
    @field:Json(name = "feels_like") val feltTemp: Double?,
    val weather: List<WeatherResponse>
) {
    override fun toString(): String =
        "ForecastResponse(dt=$dt, temp=$temp, feltTemp=$feltTemp, weather=$weather)"
}