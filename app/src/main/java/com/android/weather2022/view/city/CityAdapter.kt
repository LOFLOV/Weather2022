package com.android.weather2022.view.city

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.weather2022.R
import com.android.weather2022.network.entity.Weather

class CityAdapter(
    private var cityList: List<Weather>,
    private val onClickListener: MyOnClickListener
): RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val weather = cityList[position]
        holder.bind(weather)
        holder.itemView.setOnClickListener {
            onClickListener.onClicked(weather)
        }
    }

    override fun getItemCount(): Int = cityList.size

    fun setList(list: List<Weather>) {
        cityList = list
        notifyDataSetChanged()
    }

    class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val cityNameTextView = itemView.findViewById<TextView>(R.id.tv_item_city)

        fun bind(weather: Weather) {
            cityNameTextView.text = weather.city.name
        }
    }

    interface MyOnClickListener {
        fun onClicked(weather: Weather)
    }
}