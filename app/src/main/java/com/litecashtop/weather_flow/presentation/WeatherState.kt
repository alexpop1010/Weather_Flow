package com.litecashtop.weather_flow.presentation

import com.litecashtop.weather_flow.domain.Day

sealed class WeatherState {
    data class Success(val list: List<Day>): WeatherState()
    data class Error(val e: String): WeatherState()
    object Loading: WeatherState()
    object NoData: WeatherState()
}