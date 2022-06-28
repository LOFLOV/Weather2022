package com.android.weather2022.view.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.weather2022.network.entity.Weather
import com.android.weather2022.network.repository.WeatherRepository
import com.android.weather2022.network.repository.WeatherRepositoryImpl
import kotlin.random.Random

class DetailsViewModel : ViewModel() {

    private val weatherRepository: WeatherRepository = WeatherRepositoryImpl()

    private val _weatherLiveData: MutableLiveData<Weather> = MutableLiveData<Weather>()
    val weatherLiveData: LiveData<Weather> get() = _weatherLiveData

    private val _errorLiveData: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val errorLiveData: LiveData<Boolean> get() = _errorLiveData

    fun getWeatherData() {
        when (Random.nextInt(1)) {
            0 -> {
                _errorLiveData.postValue(true)
            }
            1 -> {
                val weather = weatherRepository.getWeather(0.0, 0.0)
                _weatherLiveData.postValue(weather)
            }
        }
    }
}