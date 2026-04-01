package com.litecashtop.weather_flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.litecashtop.weather_flow.WeatherState.Loading
import com.litecashtop.weather_flow.WeatherState.Success
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherVM(): ViewModel() {
    private val weatherRep = WeatherRepositoryImpl()

    private val _weatherList = MutableStateFlow<WeatherState>(WeatherState.NoData)
    val weatherList: StateFlow<WeatherState> = _weatherList




     fun getWeather(){
         _weatherList.value = Loading
         viewModelScope.launch(Dispatchers.IO) {
             delay(5000)
             try{
                 val data = weatherRep.getWeather()
                 _weatherList.value = Success(data)
             }catch (e: Exception){
                 _weatherList.value = WeatherState.Error("Ошибос")
             }


         }
    }

}
