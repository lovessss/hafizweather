package com.hafiz.weatheruz.db.weather_data

import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow

class WeatherDataRoomViewModel (private val dao: WeatherDataDao)  : ViewModel() {

    fun getWeatherData(): Flow<List<WeatherDataDbEntity>> = dao.getWeatherList()
}