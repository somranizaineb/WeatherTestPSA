package com.example.weathertestpsa.feature.weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.weathertestpsa.R
import com.example.weathertestpsa.common.base.BaseActivity
import com.example.weathertestpsa.common.base.replaceFragmentSafely
import com.example.weathertestpsa.feature.weather.fragments.AddTownFragment
import com.example.weathertestpsa.feature.weather.fragments.ListTownFragment

class MainActivity : BaseActivity(), TownContract.TownActivityContract{

    ///////////////////////////////////////////////////////////////////////////
    // PROPERTIES SECTION
    ///////////////////////////////////////////////////////////////////////////
    private lateinit var weatherViewModel: WeatherViewModel

    ///////////////////////////////////////////////////////////////////////////
    // ACTIVITY LIFECYCLE HANDLING
    ///////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherViewModel = viewModel()
        setContentView(R.layout.activity_main)
        //commit first fragment
        navigateTo(ListTownFragment.newInstance(), false)
        observe()
        weatherViewModel.fetchData(33, -94)
    }


    ///////////////////////////////////////////////////////////////////////////
    // OBSERVE VIEW MODEL
    ///////////////////////////////////////////////////////////////////////////
    private fun observe() {

        weatherViewModel.observeWeatherData().observe(this, Observer {
            it?.let {


            }
        })
    }

    ///////////////////////////////////////////////////////////////////////////
    // TownActivityContract IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////

    override fun navigateTo(fragment: Fragment, shouldAddToBackStack: Boolean) {
        replaceFragmentSafely(
            R.id.container,
            fragment, fragment::class.java.name,
            addToBackStack = shouldAddToBackStack,
            allowStateLoss = false
        )
    }

    override fun initToolbar(isHome: Boolean) {
        TODO("Not yet implemented")
    }


}