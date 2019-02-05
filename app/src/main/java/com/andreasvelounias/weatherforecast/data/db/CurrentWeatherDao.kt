package com.andreasvelounias.weatherforecast.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andreasvelounias.weatherforecast.data.db.entity.CURRENT_WEATHER_ID
import com.andreasvelounias.weatherforecast.data.db.entity.CurrentWeatherEntry
import com.andreasvelounias.weatherforecast.data.db.unitlocalized.ImperialCurrentWeatherEntry
import com.andreasvelounias.weatherforecast.data.db.unitlocalized.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // Insert or Update
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}