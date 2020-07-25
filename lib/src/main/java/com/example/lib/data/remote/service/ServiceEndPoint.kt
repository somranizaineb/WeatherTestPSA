package com.example.lib.data.remote.service

import com.example.lib.data.remote.response.model.WeatherTownResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by zaineb on 23/07/2020
 */
interface ServiceEndPoint {


    companion object {

        ///////////////////////////////////////////////////////////////////////////
        // end point
        ///////////////////////////////////////////////////////////////////////////
        const val ONE_CALL = "onecall"

        ///////////////////////////////////////////////////////////////////////////
        // params
        ///////////////////////////////////////////////////////////////////////////
        const val LON = "lon"
        const val LAT = "lat"
        const val EXCLUDE = "exclude"
        const val APPID = "appid"
    }


    @GET(ONE_CALL)
    suspend fun getWeatherTown(
        @Query(LAT) lat: Long,
        @Query(LON) lon: Long,
        @Query(EXCLUDE) exclude: String,
        @Query(APPID) appid: String
    ): WeatherTownResponse

}