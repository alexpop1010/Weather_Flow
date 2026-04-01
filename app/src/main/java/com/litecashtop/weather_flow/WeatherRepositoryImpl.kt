package com.litecashtop.weather_flow

import com.litecashtop.weather_flow.RetrofitClient.apiService

class WeatherRepositoryImpl: WeatherRepository {
    override suspend fun getWeather(): List<Day> {
        val response = apiService.getWeather(
            lat = 50.1,
            lon = 8.6
        )

        return mapToDays(response)
    }
}