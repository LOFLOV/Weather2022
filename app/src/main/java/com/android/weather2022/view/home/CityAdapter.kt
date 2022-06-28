package com.android.weather2022.view.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.weather2022.R
import com.android.weather2022.network.entity.Weather

class CityAdapter: RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    private var cityList: List<Weather> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val weather = cityList[position]
        holder.bind(weather)
    }

    override fun getItemCount(): Int = cityList.size

    fun setList(list: List<Weather>) {
        cityList = list
        notifyDataSetChanged()
    }

    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val cityName = itemView.findViewById<TextView>(R.id.tv_item_city)

        fun bind(weather: Weather) {
            cityName.text = weather.city.name
        }
    }
}