package com.android.weather2022.network.repository

import com.android.weather2022.network.entity.Weather

interface WeatherRepository {
    fun getWeather(lat: Double, lon: Double): Weather
}