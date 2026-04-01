package com.litecashtop.weather_flow.di


import com.litecashtop.weather_flow.data.WeatherRepositoryImpl
import com.litecashtop.weather_flow.domain.WeatherRepository
import com.litecashtop.weather_flow.presentation.WeatherVM
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val weatherModule = module {


    single<WeatherRepository> {
        WeatherRepositoryImpl()
    }


    viewModel {
        WeatherVM(get())
    }
}