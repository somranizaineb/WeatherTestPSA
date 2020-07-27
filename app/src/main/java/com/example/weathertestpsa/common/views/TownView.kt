package com.example.weathertestpsa.common.views

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lib.data.entities.Town
import com.example.weathertestpsa.R
import com.example.weathertestpsa.feature.weather.TownContract
import com.example.weathertestpsa.feature.weather.adapters.TownListAdapter
import kotlinx.android.synthetic.main.all_town_view.view.*
import java.util.*

/**
 * Created by zaineb on 26/07/2020
 */
class TownView : ConstraintLayout {

    ///////////////////////////////////////////////////////////////////////////
    // GENERAL PROPERTY SECTION
    ///////////////////////////////////////////////////////////////////////////
    private var adapter: TownListAdapter? = null
    private var allCountriesList: MutableList<Town>? = null
    private var selectedCountriesList: MutableList<Town>? = null

    ///////////////////////////////////////////////////////////////////////////
    // VIEW ATTRIBUTES SECTION
    ///////////////////////////////////////////////////////////////////////////
    private var rv: RecyclerView? = null

    ///////////////////////////////////////////////////////////////////////////
    // INTERACTION PROPERTY SECTION
    ///////////////////////////////////////////////////////////////////////////
    var townViewInteraction: TownContract.AddTownFragmentContract? = null

    ///////////////////////////////////////////////////////////////////////////
    // COUNTRIES GENERATING PROPERTY
    ///////////////////////////////////////////////////////////////////////////

    constructor(@NonNull context: Context) : super(context)

    constructor(@NonNull context: Context, @NonNull attr: AttributeSet) : super(context, attr) {
        val view = LayoutInflater.from(context).inflate(R.layout.all_town_view, this)
        rv = view.rv_town
    }

    fun initViewAccordingTo(
        listOfTowns: MutableList<Town>,
        interaction: TownContract.AddTownFragmentContract
    ) {
        allCountriesList = listOfTowns
        selectedCountriesList = mutableListOf()
        selectedCountriesList?.addAll(allCountriesList ?: arrayListOf())
        townViewInteraction = interaction
        initCountryList()
    }

    ///////////////////////////////////////////////////////////////////////////
    // INTERACTION VIEW HANDLING SECTION
    ///////////////////////////////////////////////////////////////////////////
    private fun initCountryList() {
        context?.let { ctx ->
            adapter =
                TownListAdapter(
                    selectedCountriesList,
                    object :
                        TownListAdapter.ItemClickEvent {
                        override fun onItemClick(town: Town?) {
                            townViewInteraction?.chooseTown(town)
                        }
                    }
                )
            val llm = LinearLayoutManager(ctx)
            llm.orientation = LinearLayoutManager.VERTICAL
            rv?.layoutManager = llm
            rv?.adapter = adapter
        }
    }

    @SuppressLint("DefaultLocale")
    fun search(text: String) {
        selectedCountriesList?.clear()
        allCountriesList?.let { list ->
            for (country in list) {
                buildTownListFromTownDataAndSearchedWord(text, country)
            }
        }
        adapter?.notifyDataSetChanged()
    }

    private fun buildTownListFromTownDataAndSearchedWord(text: String, town: Town) {
        town.city?.toLowerCase(Locale.getDefault())
            ?.contains(text.toLowerCase(Locale.getDefault()))?.let { doesContain ->
                if (doesContain) selectedCountriesList?.add(town)
            }
    }

}