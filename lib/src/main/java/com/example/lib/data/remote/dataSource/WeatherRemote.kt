package com.example.lib.data.remote.dataSource

import com.example.lib.data.remote.response.model.WeatherTownResponse
import com.example.lib.data.remote.service.ServiceEndPoint
import javax.inject.Inject

/**
 * Created by zaineb on 23/07/2020
 */
class WeatherRemote @Inject constructor() {

    @Inject
    lateinit var serviceEndPoint: ServiceEndPoint

    suspend fun getWeatherTownAsync(
        lat: Long,
        lon: Long,
        exclude: String,
        appId: String
    ): WeatherTownResponse = serviceEndPoint.getWeatherTown(lat, lon, exclude, appId)
}
