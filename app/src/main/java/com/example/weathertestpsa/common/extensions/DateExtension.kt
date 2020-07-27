package com.example.weathertestpsa.common.extensions

import java.sql.Date
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by zaineb on 25/07/2020
 */

const val MILLISECOND_MULTIPLIER = 1000
const val DATE_FORMAT = "MMM dd, yyyy EEEE"

fun Long.getDateTime(): String? = try {
    val sdf = SimpleDateFormat(DATE_FORMAT, Locale.UK)
    val netDate = Date(this.times(MILLISECOND_MULTIPLIER))
    sdf.format(netDate)
} catch (e: Exception) {
    e.toString()
}
