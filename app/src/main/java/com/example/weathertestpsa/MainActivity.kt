package com.example.weathertestpsa

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.weathertestpsa.common.BaseActivity
import com.example.weathertestpsa.feature.viemModel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {


    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherViewModel = viewModel()
        setContentView(R.layout.activity_main)
        observe()
        weatherViewModel.fetchData()
    }

    private fun observe() {
        weatherViewModel.observeWeatherData().observe(this, Observer {
            it?.let {

                text.text = it.toString()

                val text = "Hello toast!"
                val duration = Toast.LENGTH_SHORT

                Toast.makeText(applicationContext, text, duration).show()
            }
        })
    }
}