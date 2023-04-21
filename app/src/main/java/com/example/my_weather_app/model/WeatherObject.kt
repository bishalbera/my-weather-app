package com.example.my_weather_app.model

data class WeatherObject(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)