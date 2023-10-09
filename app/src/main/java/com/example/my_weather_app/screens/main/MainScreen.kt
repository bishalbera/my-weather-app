@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.my_weather_app.screens.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.my_weather_app.data.DataOrException
import com.example.my_weather_app.model.Weather
import com.example.my_weather_app.model.WeatherItem
import com.example.my_weather_app.navigation.WeatherScreens
import com.example.my_weather_app.utils.formatDate
import com.example.my_weather_app.utils.formatDecimals
import com.example.my_weather_app.widgets.*


@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel(),
    city: String?
) {


        val weatherData = produceState<DataOrException<Weather, Boolean, Exception>>(
            initialValue = DataOrException(loading = true)
        ) {
            value = mainViewModel.getWeatherData(city = city.toString())
        }.value

        if (weatherData.loading == true) {
            CircularProgressIndicator()
        } else if (weatherData.data != null) {
            MainScaffold(weather = weatherData.data!!, navController)


        }
    }



    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    @Composable
    fun MainScaffold(weather: Weather, navController: NavController) {

        Scaffold(topBar = {
            WeatherAppBar(
                title = weather.city.name + " ,${weather.city.country}",
                navController = navController,
                onAddActionClicked = {
                    navController.navigate(WeatherScreens.SearchScreen.name)

                },
                elevation = 5.dp
            )
        }) {
            MainContent(data = weather)
        }
    }

    @Composable
    fun MainContent(data: Weather) {
        val imageUrl = "https://openweathermap.org/img/wn/${data!!.list[0].weather[0].icon}.png"


        val weatherItem = data.list[0]
        Column(
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = formatDate(weatherItem.dt),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.onSecondary,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(5.dp)
            )

            Surface(
                modifier = Modifier
                    .padding(4.dp)
                    .size(200.dp),
                shape = CircleShape,
                color = Color(0xFFFFC400)
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    WeatherConditionImage(imageUrl = imageUrl)
                    Text(
                        text = formatDecimals(weatherItem.temp.day) + "°",
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(text = weatherItem.weather[0].main, fontStyle = FontStyle.Italic)

                }

            }

            HumWiPrRow(weather = weatherItem)
            Divider()
            SunRiseAndSetRow(weather = weatherItem)
            Text(
                text = "This Week",
                modifier = Modifier.padding(4.dp),
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold
            )

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                color = Color(0xFFEEF1EF),
                shape = RoundedCornerShape(size = 14.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.padding(2.dp),
                    contentPadding = PaddingValues(1.dp)
                ) {
                    items(items = data.list) { item: WeatherItem ->

                        WeatherDetailRow(weather = item)

                    }

                }


            }
        }
    }


