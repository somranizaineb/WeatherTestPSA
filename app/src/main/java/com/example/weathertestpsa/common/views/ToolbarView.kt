package com.example.weathertestpsa.common.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.widget.Toolbar
import com.example.weathertestpsa.R
import kotlinx.android.synthetic.main.toolbar_layout.view.*

/**
 * Created by zaineb on 27/07/2020
 */
class ToolbarView : Toolbar {

    private lateinit var titleTV: TextView
    private lateinit var previousTV: TextView

    var toolbarInteraction: ToolbarInteraction? = null

    constructor(@NonNull context: Context) : super(context)

    constructor(@NonNull context: Context, @NonNull attr: AttributeSet) : super(context, attr) {
        val view = LayoutInflater.from(context).inflate(R.layout.toolbar_layout, this)

        titleTV = view.toolbar_title
        previousTV = view.toolbar_previous

        previousTV.setOnClickListener {
            toolbarInteraction?.onBack()
        }
    }

    fun setTitle(title: String) {
        titleTV.text = title
    }

    fun hidePrevious() {
        previousTV.visibility = View.INVISIBLE
        previousTV.isEnabled = false
        previousTV.isClickable = false
    }

    fun showPrevious() {
        previousTV.visibility = View.VISIBLE
        previousTV.isEnabled = true
        previousTV.isClickable = true
    }


    interface ToolbarInteraction {
        fun onBack()
    }

}