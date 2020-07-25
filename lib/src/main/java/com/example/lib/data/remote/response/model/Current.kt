package com.example.lib.data.remote.response.model

import com.squareup.moshi.Json

class Current {
    @Json(name = "dt")
    var dt: Int? = null

    @Json(name = "sunrise")
    var sunrise: Int? = null

    @Json(name = "sunset")
    var sunset: Int? = null

    @Json(name = "temp")
    var temp: Double? = null

    @Json(name = "feels_like")
    var feelsLike: Double? = null

    @Json(name = "pressure")
    var pressure: Int? = null

    @Json(name = "humidity")
    var humidity: Int? = null

    @Json(name = "dew_point")
    var dewPoint: Double? = null

    @Json(name = "uvi")
    var uvi: Double? = null

    @Json(name = "clouds")
    var clouds: Int? = null

    @Json(name = "visibility")
    var visibility: Int? = null

    @Json(name = "wind_speed")
    var windSpeed: Double? = null

    @Json(name = "wind_deg")
    var windDeg: Int? = null

    @Json(name = "weather")
    var weather: List<Weather>? = null

    override fun toString(): String =
        "Current(dt=$dt, sunrise=$sunrise, sunset=$sunset, temp=$temp, feelsLike=$feelsLike, pressure=$pressure, humidity=$humidity, dewPoint=$dewPoint, uvi=$uvi, clouds=$clouds, visibility=$visibility, windSpeed=$windSpeed, windDeg=$windDeg, weather=$weather)"
}