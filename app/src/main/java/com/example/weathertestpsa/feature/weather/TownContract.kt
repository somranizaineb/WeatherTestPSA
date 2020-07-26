package com.example.weathertestpsa.feature.weather

import androidx.fragment.app.Fragment
import com.example.lib.data.entities.Town

/**
 * Created by zaineb on 25/07/2020
 * As a contract, this object contains all interfaces made to centralize what an Activity, Fragment
 * or ViewModel is about to handle.
 *
 */
object TownContract {


    interface TownActivityContract {
        fun navigateTo(fragment: Fragment, shouldAddToBackStack: Boolean)
        fun initToolbar(isHome: Boolean)
    }

    interface ListTownFragmentContract {
        fun initRecyclerView()
        fun initObservation()
        fun getListTownFromLocal()
        fun clickToAddNewTown()
    }

    interface WeatherViewModelContract {
        fun fetchData(lat: Long, lon: Long)
        fun retrieveWeatherInfoFromLocal(lat: Long, lon: Long)
        fun addTown(town: Town)
        fun retrieveFavoritesTownsFromLocal()
    }


}