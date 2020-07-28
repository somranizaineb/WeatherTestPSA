package com.example.weathertestpsa.feature.weather

import androidx.fragment.app.Fragment
import com.example.lib.data.entities.Town
import com.example.lib.data.remote.response.model.WeatherTownResponse

/**
 * Created by zaineb on 25/07/2020
 * As a contract, this object contains all interfaces made to centralize what an Activity, Fragment
 * or ViewModel is about to handle.
 *
 */
object WeatherContract {


    interface WeatherActivityContract {
        fun navigateTo(fragment: Fragment, shouldAddToBackStack: Boolean)
        fun initToolbar(tag: String)
        fun popBackStack()
    }

    interface ListTownFragmentContract {
        fun initToolbar()
        fun initRecyclerView()
        fun initObservation()
        fun getListTownFromLocal()
        fun clickToAddNewTown()
        fun clickToGetWeatherDetail(lat: Double, lon: Double, city: String)
    }

    interface AddTownFragmentContract {
        fun initToolbar()
        fun chooseTown(town: Town?)
    }

    interface WeatherDetailFragmentContract {
        fun initToolbar()
        fun initObservation()
        fun defineCurrentWeather(townWeather: WeatherTownResponse)
        fun initDailyWeatherRecyclerView()
    }

    interface WeatherViewModelContract {
        fun fetchData(lat: Double, lon: Double)
        fun retrieveWeatherInfoFromLocal(lat: Double, lon: Double)
        fun addTown(town: Town)
        fun retrieveFavoritesTownsFromLocal()
    }


}