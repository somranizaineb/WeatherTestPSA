package com.example.psatest.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

/**
 * Created by zaineb on 23/07/2020
 */
@Entity(tableName = "towns")
data class Town(
    @PrimaryKey
    var id: Int = 1000,
    @field:Json(name = "lat") val lat: Long,
    @field:Json(name = "lon") val lon: Long

)