package com.android.weather2022.view.city

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.weather2022.network.entity.Weather
import com.android.weather2022.network.repository.WeatherRepository
import com.android.weather2022.network.repository.WeatherRepositoryImpl

class CityViewModel: ViewModel() {

    private val weatherRepository: WeatherRepository = WeatherRepositoryImpl()

    private val _cityListLiveData: MutableLiveData<List<Weather>> = MutableLiveData<List<Weather>>()
    val cityListLiveData: LiveData<List<Weather>> get() = _cityListLiveData

    fun getCityList() {
        val cityList = weatherRepository.getCityList()
        _cityListLiveData.postValue(cityList)
    }
}