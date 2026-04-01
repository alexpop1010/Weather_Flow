package com.litecashtop.weather_flow

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.litecashtop.weather_flow.ui.theme.Weather_FlowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Weather_FlowTheme {
                Greeting(
                    name = "Android",
                    modifier = Modifier.padding()
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val vm: WeatherVM = viewModel()
    LaunchedEffect(Unit) {
        vm.getWeather()
    }
    val weatherState = vm.weatherList.collectAsState()

    Button(onClick = {vm.getWeather()}, modifier = Modifier.padding(top = 20.dp)){
        Text("getWeather")
    }
    Box(modifier = Modifier.padding(top = 100.dp)){
        when(val state = weatherState.value){
            is WeatherState.Loading -> Text("Загрузка погоды")
            is WeatherState.Success -> showWeather(state.list)
            is WeatherState.NoData ->Text("Данных еще нет")
            is WeatherState.Error -> Text("Ошибка загрузки")
        }
    }

}
@Composable
fun showWeather(lst: List<Day>){
    LazyColumn() {
        items(lst) { i->
            ShowDay(i)

        }
    }

}
