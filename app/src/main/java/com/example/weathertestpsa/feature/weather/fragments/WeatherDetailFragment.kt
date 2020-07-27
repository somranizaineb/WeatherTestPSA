package com.example.weathertestpsa.feature.weather.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lib.data.remote.response.model.WeatherTownResponse
import com.example.weathertestpsa.R
import com.example.weathertestpsa.common.extensions.defineDrawableFrom
import com.example.weathertestpsa.common.extensions.getDateTime
import com.example.weathertestpsa.common.extensions.round
import com.example.weathertestpsa.common.utils.LoadingState
import com.example.weathertestpsa.common.utils.isInternetAvailable
import com.example.weathertestpsa.feature.weather.MainActivity
import com.example.weathertestpsa.feature.weather.TownContract
import com.example.weathertestpsa.feature.weather.WeatherViewModel
import com.example.weathertestpsa.feature.weather.adapters.DailyWeatherAdapter
import kotlinx.android.synthetic.main.fragment_weather_detail.*
import kotlin.math.roundToInt


class WeatherDetailFragment : Fragment(),
    TownContract.WeatherDetailFragmentContract {

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL
    ///////////////////////////////////////////////////////////////////////////
    private lateinit var weatherViewModel: WeatherViewModel


    ///////////////////////////////////////////////////////////////////////////
    // PROPERTIES SECTION
    ///////////////////////////////////////////////////////////////////////////
    private var lat: Double = 0.0
    private var lon: Double = 0.0
    private var city: String = ""
    private var adapter: DailyWeatherAdapter? = null
    private var activityContractImp: TownContract.TownActivityContract? = null


    ///////////////////////////////////////////////////////////////////////////
    // FRAGMENT LIFECYCLE HANDLING
    ///////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let { act ->
            weatherViewModel = ViewModelProviders.of(act).get(WeatherViewModel::class.java)
        }
        //weatherViewModel = viewModel()
        arguments?.let {
            lat = it.getDouble(ARG_PARAM_lat)
            lon = it.getDouble(ARG_PARAM_lon)
            city = it.getString(ARG_PARAM_city).toString()
        }
        initObservation()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_weather_detail, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activityContractImp = activity as MainActivity
        initDailyWeatherRecyclerView()
        // check if there is connection
        if (context?.let { isInternetAvailable(it) }!!) weatherViewModel.fetchData(lat, lon)
        else weatherViewModel.retrieveWeatherInfoFromLocal(lat.round(2), lon.round(2))


    }

    override fun onResume() {
        super.onResume()
        initToolbar()
    }


    ///////////////////////////////////////////////////////////////////////////
    // IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////
    override fun initObservation() {
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

        weatherViewModel.loadingState.observe(this, Observer {
            when (it.status) {
                LoadingState.Status.FAILED -> Toast.makeText(context, it.msg, Toast.LENGTH_SHORT)
                    .show()
                LoadingState.Status.RUNNING -> Toast.makeText(
                    context,
                    "Loading",
                    Toast.LENGTH_SHORT
                ).show()
                LoadingState.Status.SUCCESS -> Toast.makeText(
                    context,
                    "Success",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun initToolbar() {
        activityContractImp?.initToolbar("DetailWeather")
    }


    ///////////////////////////////////////////////////////////////////////////
    // UI HANDLING
    ///////////////////////////////////////////////////////////////////////////
    override fun defineCurrentWeather(townWeather: WeatherTownResponse) {
        current_temp.text = getString(
            R.string.temp_degree_placeholder,
            townWeather.current?.temp?.roundToInt().toString()
        )
        current_city.text = city
        current_date.text =
            getString(R.string.temp_last_update_placeholder, townWeather.current?.dt?.getDateTime())
        current_desc.text = townWeather.current?.weather?.get(0)?.main
        current_weather_image.defineDrawableFrom(townWeather.current?.weather?.get(0)?.icon)
    }

    override fun initDailyWeatherRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context)
        daily_weather_rv.layoutManager = linearLayoutManager
        adapter = DailyWeatherAdapter()
        daily_weather_rv.adapter = adapter
    }

    companion object {

        private const val ARG_PARAM_lat = "ARG_PARAM_lat"
        private const val ARG_PARAM_lon = "ARG_PARAM_lon"
        private const val ARG_PARAM_city = "ARG_PARAM_city"

        @JvmStatic
        fun newInstance(lat: Double, lon: Double, city: String) = WeatherDetailFragment().apply {
            arguments = Bundle().apply {
                putDouble(ARG_PARAM_lat, lat)
                putDouble(ARG_PARAM_lon, lon)
                putString(ARG_PARAM_city, city)
            }
        }
    }
}