package com.example.lib.data.remote.response.model

import com.squareup.moshi.Json

open class Weather {
    @Json(name = "id")
    var id: Int? = null

    @Json(name = "main")
    var main: String? = null

    @Json(name = "description")
    var description: String? = null

    @Json(name = "icon")
    var icon: String? = null

    var currentId: Int? = null

    override fun toString(): String =
        "Weather(id=$id, main=$main, description=$description, icon=$icon)"
}