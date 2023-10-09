package com.example.my_weather_app.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.my_weather_app.model.Favorite
import com.example.my_weather_app.model.Unit

@Database(entities = [Favorite::class, Unit::class], version = 3, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}
