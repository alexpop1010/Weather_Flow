package com.litecashtop.weather_flow.data

import com.litecashtop.weather_flow.domain.Day

fun mapToDays(response: WeatherResponse): List<Day> {
    return response.daily.time.mapIndexed { index, date ->
        Day(
            date, response.daily.temperature_2m_max[index].toInt()
        )
    }
}