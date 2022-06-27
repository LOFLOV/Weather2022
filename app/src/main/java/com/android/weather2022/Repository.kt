package com.android.weather2022

interface Repository {
    fun getWeather(lat: Double, lon: Double): Weather
}