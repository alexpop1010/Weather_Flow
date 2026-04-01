package com.litecashtop.weather_flow

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ShowDay(day : Day){
    Column(){
        Text(day.day)
        Text(day.temp.toString())

    }

}