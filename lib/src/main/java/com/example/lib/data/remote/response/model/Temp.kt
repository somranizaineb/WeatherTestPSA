package com.example.lib.data.remote.response.model

import com.squareup.moshi.Json

class Temp {
    @Json(name = "day")
    var day: Double? = null

    @Json(name = "min")
    var min: Double? = null

    @Json(name = "max")
    var max: Double? = null

    @Json(name = "night")
    var night: Double? = null

    @Json(name = "eve")
    var eve: Double? = null

    @Json(name = "morn")
    var morn: Double? = null
    override fun toString(): String =
        "Temp(day=$day, min=$min, max=$max, night=$night, eve=$eve, morn=$morn)"
}