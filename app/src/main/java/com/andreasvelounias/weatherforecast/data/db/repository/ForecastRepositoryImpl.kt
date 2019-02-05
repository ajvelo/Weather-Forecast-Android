package com.andreasvelounias.weatherforecast.data.db.repository

import androidx.lifecycle.LiveData
import com.andreasvelounias.weatherforecast.data.db.CurrentWeatherDao
import com.andreasvelounias.weatherforecast.data.db.network.response.CurrentWeatherResponse
import com.andreasvelounias.weatherforecast.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry
import com.andreasvelounias.weatherforecast.data.network.WeatherNetworkDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ForecastRepositoryImpl(
    private val currentWeatherDao: CurrentWeatherDao,
    private val weatherNetworkDataSource: WeatherNetworkDataSource

) : ForecastRepository {

    init {
        weatherNetworkDataSource.downloadedCurrentWeather.observeForever { newCurrentWeather ->
            //persist
            persistFetchedCurrentWeather(newCurrentWeather)
        }
    }

    override suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry> {
        return withContext(Dispatchers.IO) {
            return@withContext if (metric) currentWeatherDao.getWeatherMetric()
            else currentWeatherDao.getWeatherImperial()
        }
    }

    private fun persistFetchedCurrentWeather(fetchedWeather: CurrentWeatherResponse) {
        GlobalScope.launch(Dispatchers.IO) {
            // update or insert
            currentWeatherDao.upsert(fetchedWeather.currentWeatherEntry)
        }
    }
}