package com.andreasvelounias.weatherforecast.data.db.repository

import androidx.lifecycle.LiveData
import com.andreasvelounias.weatherforecast.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
}