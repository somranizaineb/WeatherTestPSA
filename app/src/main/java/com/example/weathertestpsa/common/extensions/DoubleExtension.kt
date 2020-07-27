package com.example.weathertestpsa.common.extensions

import kotlin.math.round

/**
 * Created by zaineb on 27/07/2020
 */
fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}