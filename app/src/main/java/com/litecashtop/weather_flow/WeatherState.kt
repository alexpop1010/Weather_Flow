package com.litecashtop.weather_flow

sealed class WeatherState {
    data class Success(val list: List<Day>): WeatherState()
    data class Error(val e: String): WeatherState()
    object Loading: WeatherState()
    object NoData: WeatherState()
}