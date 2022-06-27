package com.android.weather2022

interface WeatherRepository {
    fun getWeather(lat: Double, lon: Double): Weather
}