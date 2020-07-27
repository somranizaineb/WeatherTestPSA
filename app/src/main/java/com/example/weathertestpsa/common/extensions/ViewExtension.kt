package com.example.weathertestpsa.common.extensions

import android.widget.ImageView

/**
 * Created by zaineb on 25/07/2020
 */

fun ImageView.defineDrawableFrom(iconName: String?) {
    val resId =
        resources.getIdentifier(
            "ic_$iconName",
            "drawable",
            "com.example.weathertestpsa"
        )
    this.setImageResource(resId)
}