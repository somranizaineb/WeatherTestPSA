package com.example.weathertestpsa.common.extensions

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Created by zaineb on 25/07/2020
 */
fun AppCompatActivity.replaceFragmentSafely(
    @IdRes layout: Int,
    fragment: Fragment,
    tag: String,
    addToBackStack: Boolean,
    allowStateLoss: Boolean = false
) {

    if (tag.isNotEmpty()) {
        val manager = supportFragmentManager
        if (manager.findFragmentByTag(tag) == null) {
            val transaction = manager.beginTransaction()
            transaction.replace(layout, fragment, tag)
            if (addToBackStack) transaction.addToBackStack(tag)
            when {
                !manager.isStateSaved -> transaction.commit()
                allowStateLoss -> transaction.commitAllowingStateLoss()
            }
            manager.executePendingTransactions()
        }
    }
}


