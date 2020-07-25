package com.example.lib.data.remote.response.model

import com.squareup.moshi.Json

class FeelsLike {
    @Json(name = "day")
    var day: Double? = null

    @Json(name = "night")
    var night: Double? = null

    @Json(name = "eve")
    var eve: Double? = null

    @Json(name = "morn")
    var morn: Double? = null
    override fun toString(): String =  "FeelsLike(day=$day, night=$night, eve=$eve, morn=$morn)"
}