package com.litecashtop.weather_flow

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("v1/forecast")
    suspend fun getWeather(
        @Query("latitude") lat: Double,
        @Query("longitude") lon: Double,
        @Query("daily") daily: String = "temperature_2m_max",
        @Query("timezone") timezone: String = "auto"
    ): WeatherResponse
}