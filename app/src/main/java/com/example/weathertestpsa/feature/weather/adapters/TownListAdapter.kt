package com.example.weathertestpsa.feature.weather.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lib.data.entities.Town
import com.example.weathertestpsa.R
import kotlinx.android.synthetic.main.town_row.view.*

/**
 * Created by zaineb on 26/07/2020
 * this adapter is for TownView
 */
class TownListAdapter(
    var towns: MutableList<Town>?,
    private var itemClickEvent: ItemClickEvent
) :
    RecyclerView.Adapter<TownListAdapter.MyHolder>() {

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.row_title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.town_row, parent, false)
        return MyHolder(
            v
        )
    }

    override fun getItemCount(): Int = towns?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.title.text = towns?.get(position)?.city
        holder.itemView.setOnClickListener {
            itemClickEvent.onItemClick(towns?.get(position))
        }
    }

    interface ItemClickEvent {
        fun onItemClick(town: Town?)
    }
}
