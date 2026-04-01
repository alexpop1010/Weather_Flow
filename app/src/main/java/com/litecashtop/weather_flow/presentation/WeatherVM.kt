package com.litecashtop.weather_flow.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.litecashtop.weather_flow.data.WeatherRepositoryImpl
import com.litecashtop.weather_flow.domain.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherVM(val weatherRep: WeatherRepository): ViewModel() {


    private val _weatherList = MutableStateFlow<WeatherState>(WeatherState.NoData)
    val weatherList: StateFlow<WeatherState> = _weatherList




     fun getWeather(){
         _weatherList.value = WeatherState.Loading
         viewModelScope.launch(Dispatchers.IO) {
             delay(5000)
             try{
                 val data = weatherRep.getWeather()
                 _weatherList.value = WeatherState.Success(data)
             }catch (e: Exception){
                 _weatherList.value = WeatherState.Error("Ошибос")
             }


         }
    }

}