package com.litecashtop.weather_flow

interface WeatherRepository {
    suspend fun getWeather(): List<Day>
}