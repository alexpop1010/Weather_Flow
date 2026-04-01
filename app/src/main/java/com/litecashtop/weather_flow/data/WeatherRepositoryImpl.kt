package com.litecashtop.weather_flow.data

import com.litecashtop.weather_flow.domain.Day
import com.litecashtop.weather_flow.domain.WeatherRepository

class WeatherRepositoryImpl: WeatherRepository {
    override suspend fun getWeather(): List<Day> {
        val response = RetrofitClient.apiService.getWeather(
            lat = 50.1,
            lon = 8.6
        )

        return mapToDays(response)
    }
}