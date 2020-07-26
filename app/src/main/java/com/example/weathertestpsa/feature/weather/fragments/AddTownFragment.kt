package com.example.weathertestpsa.feature.weather.fragments

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lib.data.entities.Town
import com.example.lib.data.entities.Town.Companion.buildCityFromJson
import com.example.weathertestpsa.R
import com.example.weathertestpsa.common.base.BaseFragment
import com.example.weathertestpsa.common.extension.loadJSONFromAsset
import com.example.weathertestpsa.common.view.TownView
import com.example.weathertestpsa.feature.weather.WeatherViewModel
import kotlinx.android.synthetic.main.fragment_add_town.*

class AddTownFragment : BaseFragment(), TownView.TownViewInteraction {


    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL
    ///////////////////////////////////////////////////////////////////////////
    private lateinit var weatherViewModel: WeatherViewModel

    ///////////////////////////////////////////////////////////////////////////
    // PROPERTIES SECTION
    ///////////////////////////////////////////////////////////////////////////
    private lateinit var listOfTowns: MutableList<Town>

    ///////////////////////////////////////////////////////////////////////////
    // FRAGMENT LIFECYCLE HANDLING
    ///////////////////////////////////////////////////////////////////////////
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        weatherViewModel = viewModel()
        Handler().postDelayed({
            val cityString = context?.loadJSONFromAsset()
            listOfTowns = buildCityFromJson(cityString)
            townView.initViewAccordingTo(listOfTowns, this)

        }, 1000)


        search?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Log.i("Bottom Sheet", "" + s)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Log.i("Bottom Sheet", "" + s)
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                townView?.search(s.toString())
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_town, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() = AddTownFragment()
    }

    ///////////////////////////////////////////////////////////////////////////
    // TownViewInteraction IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////
    override fun chooseTown(town: Town?) {
        // add town to data base
        town?.let { weatherViewModel.addTown(it) }
        // notify activity to back to towns list screen
    }


}