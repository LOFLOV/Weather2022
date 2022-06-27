package com.android.weather2022

class RepositoryImpl: Repository {
    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }
}