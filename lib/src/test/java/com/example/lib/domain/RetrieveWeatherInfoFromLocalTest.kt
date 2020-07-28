package com.example.lib.domain

import com.example.lib.data.repository.WeatherRepository
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by zaineb on 27/07/2020
 */
class RetrieveWeatherInfoFromLocalTest {

    private lateinit var sut: RetrieveWeatherInfoFromLocal

    @Mock
    lateinit var repository: WeatherRepository


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sut = RetrieveWeatherInfoFromLocal(repository)
    }

    @Test
    fun `when lat and are zero, should get null`() =runBlockingTest {

            //Given
            val lat = 0.0
            val lng = 0.0

            //When
            sut.execute(lat, lng)

            //Then
            assertEquals(null, repository.getWeatherInfoFromLocal(lat, lng))
        }

    @Test
    fun `when lat and are double, should get not null`() = runBlockingTest {

        //Given
        val lat = 48.85
        val lng = 2.35

        //When
        sut.execute(lat, lng)

        //Then
        assertNotEquals(null, repository.getWeatherInfoFromLocal(lat, lng))
    }


}