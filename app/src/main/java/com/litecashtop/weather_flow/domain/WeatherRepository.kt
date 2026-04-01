package com.litecashtop.weather_flow.domain

interface WeatherRepository {
    suspend fun getWeather(): List<Day>
}