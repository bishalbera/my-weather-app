package com.example.my_weather_app.screens.favorite

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.my_weather_app.model.Favorite
import com.example.my_weather_app.repository.WeatherDbRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: WeatherDbRepository):ViewModel() {

    private val _favList = MutableStateFlow<List<Favorite>>(emptyList())
    val favlist = _favList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getFavorites().distinctUntilChanged()
                .collect{ listOfFavs->
                    if(listOfFavs.isNullOrEmpty()){
                        Log.d("", ": Empty favs")
                    }else {
                        _favList.value = listOfFavs
                        Log.d("Favs",":${favlist.value}")
                    }

                }
        }
    }
    fun insertFavorite(favorite: Favorite) = viewModelScope.launch { repository.insertFavorite(favorite) }
    fun updateFavorite(favorite: Favorite) = viewModelScope.launch { repository.updateFavorite(favorite) }
    fun deleteFavorite(favorite: Favorite) = viewModelScope.launch { repository.deleteFavorite(favorite) }

}