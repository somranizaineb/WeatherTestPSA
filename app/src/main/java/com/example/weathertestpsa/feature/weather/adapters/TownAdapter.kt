package com.example.weathertestpsa.feature.weather.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lib.data.entities.Town
import com.example.weathertestpsa.R
import com.example.weathertestpsa.feature.weather.TownContract
import kotlinx.android.synthetic.main.item_town.view.*

/**
 * Created by zaineb on 27/07/2020
 */
class TownAdapter(private val listener: TownContract.ListTownFragmentContract) :
    RecyclerView.Adapter<TownAdapter.TownViewHolder>() {


    ///////////////////////////////////////////////////////////////////////////
    // PROPERTIES SECTION
    ///////////////////////////////////////////////////////////////////////////
    private val townList: MutableList<Town> = mutableListOf()

    fun defineTownListData(list: List<Town>) {
        townList.clear()
        townList.addAll(list)
        notifyDataSetChanged()
    }

    inner class TownViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val townTv: TextView = view.town_name
        fun bindDataToAssociatedView(town: Town?) {
            townTv.text = town?.city
            townTv.setOnClickListener {
                town?.lat?.let { it1 ->
                    town.city?.let { it2 ->
                        listener.clickToGetWeatherDetail(
                            it1, town.lng,
                            it2
                        )
                    }
                }
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // IMPLEMENTATION SECTION
    ///////////////////////////////////////////////////////////////////////////

    override fun getItemCount(): Int = townList.size

    override fun onBindViewHolder(holder: TownViewHolder, position: Int) {
        holder.bindDataToAssociatedView(townList[position])
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TownViewHolder = TownViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_town, parent, false)
    )

}