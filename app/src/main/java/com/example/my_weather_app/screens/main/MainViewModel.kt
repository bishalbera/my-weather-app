package com.example.my_weather_app.screens.main

import androidx.lifecycle.ViewModel
import com.example.my_weather_app.data.DataOrException
import com.example.my_weather_app.model.Weather
import com.example.my_weather_app.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository): ViewModel() {

    suspend fun getWeatherData(city: String, units: String)
            : DataOrException<Weather, Boolean, Exception> {
        return repository.getWeather(cityQuery = city, units = units )

    }






}