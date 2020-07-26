package com.example.weathertestpsa.feature.weather.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lib.data.remote.response.model.WeatherTownResponse
import com.example.weathertestpsa.R
import com.example.weathertestpsa.common.base.BaseFragment
import com.example.weathertestpsa.common.extension.defineDrawableFrom
import com.example.weathertestpsa.common.extension.getDateTime
import com.example.weathertestpsa.feature.weather.WeatherViewModel
import com.example.weathertestpsa.feature.weather.adapters.DailyWeatherAdapter
import kotlinx.android.synthetic.main.fragment_weather_detail.*
import kotlin.math.roundToInt


class WeatherDetailFragment : BaseFragment() {

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL
    ///////////////////////////////////////////////////////////////////////////
    private lateinit var weatherViewModel: WeatherViewModel

    ///////////////////////////////////////////////////////////////////////////
    // PROPERTIES SECTION
    ///////////////////////////////////////////////////////////////////////////
    private var lat: Long = 0
    private var lon: Long = 0

    private var adapter: DailyWeatherAdapter? = null


    ///////////////////////////////////////////////////////////////////////////
    // FRAGMENT LIFECYCLE HANDLING
    ///////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherViewModel = viewModel()
        arguments?.let {
            lat = it.getLong(ARG_PARAM_lat)
            lon = it.getLong(ARG_PARAM_lon)
        }
        initObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_weather_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDailyWeatherRecyclerView()
        weatherViewModel.retrieveWeatherInfoFromLocal(lat, lon)
    }

    ///////////////////////////////////////////////////////////////////////////
    // OBSERVERS INITIALISATION
    ///////////////////////////////////////////////////////////////////////////
    private fun initObserver() {
        weatherViewModel.observeWeatherDetailLiveData()
            .observe(this, Observer { result ->
                result?.let { weatherResponseObject ->
                    defineCurrentWeather(weatherResponseObject)
                    weatherResponseObject.daily?.let { dailyList ->
                        daily_weather_title.text =
                            getString(R.string.temp_daily_title_degree_placeholder, dailyList.size)
                        adapter?.defineDailyListData(
                            dailyList
                        )
                    }
                }
            })
    }

    ///////////////////////////////////////////////////////////////////////////
    // UI HANDLING
    ///////////////////////////////////////////////////////////////////////////
    private fun defineCurrentWeather(townWeather: WeatherTownResponse) {
        current_temp.text =
            getString(
                R.string.temp_degree_placeholder,
                townWeather.current?.temp?.roundToInt().toString()
            )
        //FIXME
        current_city.text = "Paris"
        current_date.text =
            getString(R.string.temp_last_update_placeholder, townWeather.current?.dt?.getDateTime())
        current_desc.text = townWeather.current?.weather?.get(0)?.main
        current_weather_image.defineDrawableFrom(townWeather.current?.weather?.get(0)?.icon)
    }

    private fun initDailyWeatherRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context)
        daily_weather_rv.layoutManager = linearLayoutManager
        adapter = DailyWeatherAdapter()
        daily_weather_rv.adapter = adapter
    }

    companion object {

        private const val ARG_PARAM_lat = "ARG_PARAM_lat"
        private const val ARG_PARAM_lon = "ARG_PARAM_lon"

        @JvmStatic
        fun newInstance(lat: Long, lon: Long) = WeatherDetailFragment().apply {
            arguments = Bundle().apply {
                putLong(ARG_PARAM_lat, lat)
                putLong(ARG_PARAM_lon, lon)
            }
        }
    }
}