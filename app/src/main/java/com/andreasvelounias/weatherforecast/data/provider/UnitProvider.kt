package com.andreasvelounias.weatherforecast.data.provider

import com.andreasvelounias.weatherforecast.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}