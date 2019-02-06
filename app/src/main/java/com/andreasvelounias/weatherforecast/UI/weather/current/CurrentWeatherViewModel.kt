package com.andreasvelounias.weatherforecast.UI.weather.current

import androidx.lifecycle.ViewModel;
import com.andreasvelounias.weatherforecast.data.db.repository.ForecastRepository
import com.andreasvelounias.weatherforecast.data.provider.UnitProvider
import com.andreasvelounias.weatherforecast.internal.UnitSystem
import com.andreasvelounias.weatherforecast.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {

    private val unitSystem =  unitProvider.getUnitSystem()

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }
}
