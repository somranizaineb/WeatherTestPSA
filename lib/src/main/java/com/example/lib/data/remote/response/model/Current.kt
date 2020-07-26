package com.example.lib.data.remote.response.model

import com.squareup.moshi.Json

class Current {
    @Json(name = "dt")
    var dt: Long? = null

    @Json(name = "temp")
    var temp: Float? = null

    @Json(name = "weather")
    var weather: MutableList<Weather>? = null

    var weatherTownResponseId: Int? = null

    override fun toString(): String {
        return "Current(dt=$dt, temp=$temp, weather=$weather, weatherTownResponseId=$weatherTownResponseId)"
    }
}
