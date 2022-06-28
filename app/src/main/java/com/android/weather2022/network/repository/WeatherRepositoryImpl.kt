package com.android.weather2022.network.repository

import com.android.weather2022.network.entity.City
import com.android.weather2022.network.entity.Weather

class WeatherRepositoryImpl : WeatherRepository {

    override fun getWeather(lat: Double, lon: Double): Weather {
        return Weather()
    }

    override fun getCityList(): List<Weather> = listOf(
        Weather(City("Лондон", 51.5085300, -0.1257400), 1, 2),
        Weather(City("Токио", 35.6895000, 139.6917100), 3, 4),
        Weather(City("Париж", 48.8534100, 2.3488000), 5, 6),
        Weather(City("Берлин", 52.52000659999999, 13.404953999999975), 7, 8),
        Weather(City("Рим", 41.9027835, 12.496365500000024), 9, 10),
        Weather(City("Минск", 53.90453979999999, 27.561524400000053), 11, 12),
        Weather(City("Стамбул", 41.0082376, 28.97835889999999), 13, 14),
        Weather(City("Вашингтон", 38.9071923, -77.03687070000001), 15, 16),
        Weather(City("Киев", 50.4501, 30.523400000000038), 17, 18),
        Weather(City("Пекин", 39.90419989999999, 116.40739630000007), 19, 20)
    )
}