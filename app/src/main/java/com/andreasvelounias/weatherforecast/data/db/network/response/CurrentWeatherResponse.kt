package com.andreasvelounias.weatherforecast.data.db.network.response

import com.andreasvelounias.weatherforecast.data.db.entity.CurrentWeatherEntry
import com.andreasvelounias.weatherforecast.data.db.entity.Location
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    val location: Location,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)