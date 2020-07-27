package com.example.lib.data.entities

import androidx.room.Entity
import com.google.gson.Gson
import org.json.JSONArray
import java.io.Serializable

/**
 * Created by zaineb on 23/07/2020
 */
@Entity(tableName = "towns", primaryKeys = ["lat", "lng"])

class Town : Serializable {
    var country: String? = null
    var city: String? = null
    var lat: Double = 0.0
    var lng: Double = 0.0


    override fun toString(): String {
        return "Town(country=$country, city=$city, lat=$lat, lng=$lng)"
    }

    companion object {
        fun buildCityFromJson(cityJsonString: String?): MutableList<Town> {
            val list = mutableListOf<Town>()
            val jsonArray = JSONArray(cityJsonString)

            for (index in 0..jsonArray.length().minus(1)) {
                list.add(Gson().fromJson(jsonArray.getString(index), Town::class.java))
            }

            return list
        }
    }
}