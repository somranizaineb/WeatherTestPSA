package com.example.lib.data.remote.response.model

import com.squareup.moshi.Json

class Daily {
    @Json(name = "dt")
    var dt: Int? = null

    @Json(name = "sunrise")
    var sunrise: Int? = null

    @Json(name = "sunset")
    var sunset: Int? = null

    @Json(name = "temp")
    var temp: Temp? = null

    @Json(name = "feels_like")
    var feelsLike: FeelsLike? = null

    @Json(name = "pressure")
    var pressure: Int? = null

    @Json(name = "humidity")
    var humidity: Int? = null

    @Json(name = "dew_point")
    var dewPoint: Double? = null

    @Json(name = "wind_speed")
    var windSpeed: Double? = null

    @Json(name = "wind_deg")
    var windDeg: Int? = null

    @Json(name = "weather")
    var weather: List<Weather>? = null

    @Json(name = "clouds")
    var clouds: Int? = null

    @Json(name = "pop")
    var pop: Double? = null

    @Json(name = "rain")
    var rain: Double? = null

    @Json(name = "uvi")
    var uvi: Double? = null
    override fun toString(): String = "Daily(dt=$dt, sunrise=$sunrise, sunset=$sunset, temp=$temp, feelsLike=$feelsLike, pressure=$pressure, humidity=$humidity, dewPoint=$dewPoint, windSpeed=$windSpeed, windDeg=$windDeg, weather=$weather, clouds=$clouds, pop=$pop, rain=$rain, uvi=$uvi)"
}