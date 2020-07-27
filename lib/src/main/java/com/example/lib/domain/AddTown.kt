package com.example.lib.domain

import com.example.lib.data.repository.WeatherRepository
import com.example.lib.data.entities.Town
import javax.inject.Inject

/**
 * Created by zaineb on 23/07/2020
 */
class AddTown @Inject constructor(private val weatherRepository: WeatherRepository) {


    suspend fun execute(town: Town) =
        weatherRepository.addTown(town)

}