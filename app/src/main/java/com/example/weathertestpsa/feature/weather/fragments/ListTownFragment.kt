package com.example.weathertestpsa.feature.weather.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.weathertestpsa.R
import com.example.weathertestpsa.common.base.BaseFragment
import com.example.weathertestpsa.feature.weather.MainActivity
import com.example.weathertestpsa.feature.weather.TownContract
import com.example.weathertestpsa.feature.weather.WeatherViewModel
import kotlinx.android.synthetic.main.fragment_list_town.*


class ListTownFragment : BaseFragment(),
    TownContract.ListTownFragmentContract {

    ///////////////////////////////////////////////////////////////////////////
    // VIEWMODEL
    ///////////////////////////////////////////////////////////////////////////
    private lateinit var weatherViewModel: WeatherViewModel

    ///////////////////////////////////////////////////////////////////////////
    // PROPERTIES SECTION
    ///////////////////////////////////////////////////////////////////////////
    private var activityContractImp: TownContract.TownActivityContract? = null


    ///////////////////////////////////////////////////////////////////////////
    // FRAGMENT LIFECYCLE HANDLING
    ///////////////////////////////////////////////////////////////////////////
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_town, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        weatherViewModel = viewModel()
        activityContractImp = activity as MainActivity
        weatherViewModel.retrieveFavoritesTownsFromLocal()
        clickToAddNewTown()
        initObservation()
    }


    ///////////////////////////////////////////////////////////////////////////
    // ListTownFragmentContract IMPLEMENTATION
    ///////////////////////////////////////////////////////////////////////////
    override fun initRecyclerView() {
        TODO("Not yet implemented")

    }

    override fun initObservation() {

        weatherViewModel.observeFavoritesTownsLiveData()
            .observe(viewLifecycleOwner, Observer { list ->
                list?.let {
                    Toast.makeText(activity, "Its toast!", Toast.LENGTH_SHORT).show()
                }

            })
    }

    override fun getListTownFromLocal() {
        TODO("Not yet implemented")
    }

    override fun clickToAddNewTown() {

        add_town.setOnClickListener {
            //FIXME juste for test
            activityContractImp?.navigateTo(WeatherDetailFragment.newInstance(33, -94), true)
            //activityContractImp?.navigateTo(AddTownFragment.newInstance(), true)
        }
    }


    companion object {
        fun newInstance() = ListTownFragment()

    }
}