package com.android.weather2022.network.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    val city: City = City("Москва", 55.755826, 37.617299900000035),
    val temperature: Int = 20,
    val feelsLike: Int = 20
): Parcelable