package com.example.my_weather_app.repository

import android.util.Log
import com.example.my_weather_app.data.DataOrException
import com.example.my_weather_app.model.Weather
import com.example.my_weather_app.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(cityQuery: String, ):DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(query = cityQuery, )
        }catch (e: Exception){
            Log.d("rex", "getWeather: $e")
            return DataOrException(e=e)
        }
        Log.d("INSIDE", "getWeather: $response")
        return DataOrException(data = response)


    }

}
