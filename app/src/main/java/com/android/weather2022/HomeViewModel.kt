package com.android.weather2022

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {

    private val weatherRepository: WeatherRepository = WeatherRepositoryImpl()

    private val _weatherLiveData: MutableLiveData<Weather> = MutableLiveData<Weather>()
    val weatherLiveData: LiveData<Weather> get() = _weatherLiveData

    fun getWeatherData() {
        val weather = weatherRepository.getWeather(0.0, 0.0)
        _weatherLiveData.postValue(weather)
    }
}