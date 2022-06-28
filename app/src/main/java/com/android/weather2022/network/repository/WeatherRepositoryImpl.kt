package com.android.weather2022.network.repository

import com.android.weather2022.network.entity.Weather

class WeatherRepositoryImpl: WeatherRepository {

    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }
}