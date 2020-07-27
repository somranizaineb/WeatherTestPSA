package com.example.weathertestpsa.feature.weather.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weathertestpsa.R
import com.example.weathertestpsa.feature.weather.MainActivity
import com.example.weathertestpsa.feature.weather.TownContract
import com.example.weathertestpsa.feature.weather.WeatherViewModel
import com.example.weathertestpsa.feature.weather.adapters.TownAdapter
import kotlinx.android.synthetic.main.fragment_list_town.*


class ListTownFragment : Fragment(),
    TownContract.ListTownFragmentContract{

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL
    ///////////////////////////////////////////////////////////////////////////
    private lateinit var weatherViewModel: WeatherViewModel

    ///////////////////////////////////////////////////////////////////////////
    // PROPERTIES SECTION
    ///////////////////////////////////////////////////////////////////////////
    private var activityContractImp: TownContract.TownActivityContract? = null
    private var adapter: TownAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let { act ->
            weatherViewModel = ViewModelProviders.of(act).get(WeatherViewModel::class.java)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_town, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activityContractImp = activity as MainActivity
        initRecyclerView()
        getListTownFromLocal()
        initObservation()
        clickToAddNewTown()
    }

    override fun onResume() {
        super.onResume()
        initToolbar()
    }


    override fun initToolbar() {
        activityContractImp?.initToolbar("ListTown")
    }


    ///////////////////////////////////////////////////////////////////////////
    // ListTownFragmentContract IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////
    override fun initRecyclerView() {
        val linearLayoutManager = LinearLayoutManager(context)
        town_rv.layoutManager = linearLayoutManager
        adapter = TownAdapter(this)
        town_rv.adapter = adapter

    }

    override fun initObservation() {

        weatherViewModel.observeFavoritesTownsLiveData()
            .observe(viewLifecycleOwner, Observer { list ->
                list?.let {
                    adapter?.defineTownListData(it)
                }

            })
    }

    override fun getListTownFromLocal() {
        weatherViewModel.retrieveFavoritesTownsFromLocal()
    }

    override fun clickToAddNewTown() {
        add_town.setOnClickListener {
            activityContractImp?.navigateTo(AddTownFragment.newInstance(), true)
        }
    }

    override fun clickToGetWeatherDetail(lat: Double, lon: Double, city: String) {
        activityContractImp?.navigateTo(WeatherDetailFragment.newInstance(lat, lon, city), true)
    }


    companion object {
        fun newInstance() = ListTownFragment()

    }

}