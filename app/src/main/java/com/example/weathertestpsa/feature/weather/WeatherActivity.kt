package com.example.weathertestpsa.feature.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.weathertestpsa.R
import com.example.weathertestpsa.common.constants.ADD_TOWN
import com.example.weathertestpsa.common.constants.DETAIL_WEATHER
import com.example.weathertestpsa.common.constants.LIST_TOWN
import com.example.weathertestpsa.common.extensions.replaceFragmentSafely
import com.example.weathertestpsa.common.views.ToolbarView
import com.example.weathertestpsa.feature.weather.fragments.ListTownFragment
import kotlinx.android.synthetic.main.activity_main.*

class WeatherActivity : AppCompatActivity(),
    ToolbarView.ToolbarInteraction,
    WeatherContract.WeatherActivityContract {

    ///////////////////////////////////////////////////////////////////////////
    // ACTIVITY LIFECYCLE HANDLING
    ///////////////////////////////////////////////////////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.toolbarInteraction = this
        //commit first fragment
        navigateTo(ListTownFragment.newInstance(), true)

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


    override fun initToolbar(tag: String) {
        when (tag) {
            ADD_TOWN -> {
                toolbar.setTitle(getString(R.string.add_town_title))
                toolbar.showPrevious()
            }
            LIST_TOWN -> {
                toolbar.setTitle(getString(R.string.list_town))
                toolbar.hidePrevious()
            }
            DETAIL_WEATHER -> {
                toolbar.setTitle(getString(R.string.weather_details))
                toolbar.showPrevious()
            }
        }
    }

    /**
     * go back to the previous fragment
     */
    override fun popBackStack() {
        supportFragmentManager.popBackStack()
    }

    override fun onBack() {
        supportFragmentManager.popBackStack()
    }


}