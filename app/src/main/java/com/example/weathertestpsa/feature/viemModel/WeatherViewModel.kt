package com.example.weathertestpsa.feature.viemModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lib.data.remote.response.model.WeatherTownResponse
import com.example.lib.domain.GetWeatherByTown
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by zaineb on 24/07/2020
 */
class WeatherViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var getWeatherByTown: GetWeatherByTown

    private val weatherLiveData = MutableLiveData<WeatherTownResponse>()
    fun observeWeatherData(): LiveData<WeatherTownResponse> = weatherLiveData


    fun fetchData() {
        viewModelScope.launch {
            val weatherAsync = async { getWeatherByTown.execute() }
            val weather = weatherAsync.await()

            weatherLiveData.postValue(weather)
        }
    }
}
//suspend