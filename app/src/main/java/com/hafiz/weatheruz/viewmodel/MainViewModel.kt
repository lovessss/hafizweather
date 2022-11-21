package com.hafiz.weatheruz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hafiz.weatheruz.api.WeatherRepository
import com.hafiz.weatheruz.model.CurrentWeatherModel
import com.hafiz.weatheruz.model.MainWeatherModel
import com.weatherforcast.db.AppDatabase

class MainViewModel : ViewModel() {
    val repository = WeatherRepository( )



    val error = MutableLiveData<String>()
    val progress = MutableLiveData<Boolean>()
    val currentWeatherData = MutableLiveData<CurrentWeatherModel>()
    val forecastWeatherData = MutableLiveData<MainWeatherModel>()

    fun getCurrentLocationWeather(lat: String, lon: String, app_idd: String) {
        repository.getCurrentLocationWeather(
            lat,
            lon,
            app_idd,
            error,
            progress,
            currentWeatherData,
        )
    }

    fun getForecast5DayWeather(lat: String, lon: String, app_idd: String) {
        repository.getForecast5DayWeather(lat, lon, app_idd, error, progress, forecastWeatherData)
    }


    fun getSearchCityWeather(search_city: String, app_idd: String) {
        repository.getSearchCityWeather(search_city, app_idd, error, progress, currentWeatherData)
    }

    fun getSearchCity5DayWeather(search_city: String, app_idd: String) {
        repository.getSearchCity5DayWeather(
            search_city,
            app_idd,
            error,
            progress,
            forecastWeatherData
        )
    }
}