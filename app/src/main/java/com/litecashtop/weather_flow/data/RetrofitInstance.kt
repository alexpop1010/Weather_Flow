package com.litecashtop.weather_flow.data

import com.litecashtop.weather_flow.data.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.open-meteo.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: WeatherApi = retrofit.create(WeatherApi::class.java)
}