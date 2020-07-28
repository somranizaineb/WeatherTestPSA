package com.example.lib.data.remote.response.model

import androidx.room.TypeConverters
import com.example.lib.data.local.converters.Converters
import com.squareup.moshi.Json

class Daily(
    @Json(name = "dt")
    var dt: Long? = null,

    @Json(name = "temp")
    var temp: Temp? = null,

    @Json(name = "weather")
    @TypeConverters(Converters::class)
    var weather: List<Weather>? = null
)

