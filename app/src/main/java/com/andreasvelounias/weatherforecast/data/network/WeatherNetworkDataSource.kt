package com.andreasvelounias.weatherforecast.data.network

import androidx.lifecycle.LiveData
import com.andreasvelounias.weatherforecast.data.db.network.response.CurrentWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )
}