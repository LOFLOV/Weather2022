package com.android.weather2022

class WeatherRepositoryImpl: WeatherRepository {

    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }
}