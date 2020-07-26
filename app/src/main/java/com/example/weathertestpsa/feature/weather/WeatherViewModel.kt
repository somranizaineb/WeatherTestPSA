package com.example.weathertestpsa.feature.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lib.data.entities.TownWeather
import com.example.lib.data.entities.townWeatherBuilder
import com.example.lib.data.remote.response.model.WeatherTownResponse
import com.example.lib.data.remote.response.model.townWeatherBuilder
import com.example.lib.domain.*
import com.example.lib.data.entities.Town
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by zaineb on 24/07/2020
 */
class WeatherViewModel @Inject constructor() : ViewModel(),
    TownContract.WeatherViewModelContract {


    ///////////////////////////////////////////////////////////////////////////
    // USE CASE INJECTION SECTION
    ///////////////////////////////////////////////////////////////////////////

    @Inject
    lateinit var getWeatherByTown: GetWeatherByTown

    @Inject
    lateinit var addWeatherInfoToLocal: AddWeatherInfoToLocal

    @Inject
    lateinit var retrieveWeatherInfoFromLocal: RetrieveWeatherInfoFromLocal

    @Inject
    lateinit var addTown: AddTown

    @Inject
    lateinit var retrieveFavoritesTownsFromLocal: RetrieveFavoritesTownsFromLocal


    ///////////////////////////////////////////////////////////////////////////
    // OBSERVE FUNCTION SECTION
    ///////////////////////////////////////////////////////////////////////////
    private val weatherLiveData = MutableLiveData<WeatherTownResponse>()
    fun observeWeatherData(): LiveData<WeatherTownResponse> = weatherLiveData

    private val weatherDetailLiveData = MutableLiveData<WeatherTownResponse?>()
    fun observeWeatherDetailLiveData(): LiveData<WeatherTownResponse?> = weatherDetailLiveData

    private val favoritesTownsLiveData = MutableLiveData<List<Town>?>()
    fun observeFavoritesTownsLiveData(): LiveData<List<Town>?> = favoritesTownsLiveData


    ///////////////////////////////////////////////////////////////////////////
    // WeatherViewModelContract IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////
    override fun fetchData(lat: Long, lon: Long) {
        viewModelScope.launch {
            val weatherAsync = async { getWeatherByTown.execute(lat, lon) }
            val weather = weatherAsync.await()
            addWeatherInfoToLocal(weather.townWeatherBuilder())
            weatherLiveData.postValue(weather)
        }
    }

    private fun addWeatherInfoToLocal(townWeather: TownWeather) {
        viewModelScope.launch {
            addWeatherInfoToLocal.execute(townWeather)
        }
    }

    override fun retrieveWeatherInfoFromLocal(lat: Long, lon: Long) {
        viewModelScope.launch {
            val weatherAsync = async { retrieveWeatherInfoFromLocal.execute(lat, lon) }
            val weather = weatherAsync.await()
            weatherDetailLiveData.postValue(weather.townWeatherBuilder())
        }
    }

    override fun addTown(town: Town) {
        viewModelScope.launch { addTown.execute(town) }
    }

    override fun retrieveFavoritesTownsFromLocal() {
        viewModelScope.launch {
            val townsAsync = async { retrieveFavoritesTownsFromLocal.execute() }
            val towns = townsAsync.await()
            favoritesTownsLiveData.postValue(towns)
        }
    }


}
