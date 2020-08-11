package com.example.weathertestpsa.feature.weather.fragments

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.lib.data.entities.Town
import com.example.lib.data.entities.Town.Companion.buildTownFromJson
import com.example.weathertestpsa.R
import com.example.weathertestpsa.common.extensions.loadJSONFromAsset
import com.example.weathertestpsa.feature.weather.WeatherActivity
import com.example.weathertestpsa.feature.weather.WeatherContract
import com.example.weathertestpsa.feature.weather.WeatherViewModel
import kotlinx.android.synthetic.main.fragment_add_town.*
import javax.inject.Inject

class AddTownFragment : Fragment(),
    WeatherContract.AddTownFragmentContract {


    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL
    ///////////////////////////////////////////////////////////////////////////
    private lateinit var weatherViewModel: WeatherViewModel

    ///////////////////////////////////////////////////////////////////////////
    // PROPERTIES SECTION
    ///////////////////////////////////////////////////////////////////////////
    private lateinit var listOfTowns: MutableList<Town>
    private var activityContractImp: WeatherContract.WeatherActivityContract? = null

    ///////////////////////////////////////////////////////////////////////////
    // FRAGMENT LIFECYCLE HANDLING
    ///////////////////////////////////////////////////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let { act ->
            weatherViewModel =  ViewModelProvider(this).get(WeatherViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_town, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activityContractImp = activity as WeatherActivity
        Handler().postDelayed({
            val cityString = context?.loadJSONFromAsset()
            listOfTowns = buildTownFromJson(cityString)
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


    override fun onResume() {
        super.onResume()
        initToolbar()
    }

    ///////////////////////////////////////////////////////////////////////////
    // AddTownFragmentContract IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////
    override fun initToolbar() {
        activityContractImp?.initToolbar("addTown")
    }
    override fun chooseTown(town: Town?) {
        // add town to data base
        town?.let {
            weatherViewModel.addTown(it)
            // notify activity to back to towns list screen
            activityContractImp?.popBackStack()
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = AddTownFragment()
    }


}