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
        // ENDPOINTS
        ///////////////////////////////////////////////////////////////////////////
        const val ONE_CALL = "onecall"

        ///////////////////////////////////////////////////////////////////////////
        // PARAMS
        ///////////////////////////////////////////////////////////////////////////
        const val LON = "lon"
        const val LAT = "lat"
        const val EXCLUDE = "exclude"
        const val APPID = "appid"
        const val UNITS = "units"
        const val LANGUAGE = "lang"
    }


    ///////////////////////////////////////////////////////////////////////////
    // method
    ///////////////////////////////////////////////////////////////////////////
    @GET(ONE_CALL)
    suspend fun getWeatherTown(
        @Query(LAT) lat: Double,
        @Query(LON) lon: Double,
        @Query(EXCLUDE) exclude: String,
        @Query(APPID) appid: String,
        @Query(UNITS) units : String,
        @Query(LANGUAGE) lang : String
    ): WeatherTownResponse


}