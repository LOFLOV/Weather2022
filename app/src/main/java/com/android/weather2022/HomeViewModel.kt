package com.android.weather2022

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel(val liveData: MutableLiveData<Any> = MutableLiveData<Any>()): ViewModel() {

    lateinit var repository: Repository

}