package com.litecashtop.weather_flow

data class WeatherResponse(
    val daily: Daily
)

data class Daily(
    val time: List<String>,
    val temperature_2m_max: List<Double>
)
