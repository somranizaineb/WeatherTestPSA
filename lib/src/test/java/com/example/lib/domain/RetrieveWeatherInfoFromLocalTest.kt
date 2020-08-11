package com.example.lib.domain

import com.example.lib.common.whenever
import com.example.lib.data.repository.WeatherRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
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

    @ExperimentalCoroutinesApi
    @Test
    fun `when lat and are zero, should get null`() = runBlockingTest {


        //Given
        val lat = 0.0
        val lng = 0.0

        val response = null
        whenever(
            repository.getWeatherInfoFromLocal(
                lat,
                lng
            )
        )
            .thenReturn(response)

        val result = sut.execute(lat, lng)

        //Then
        assertEquals(null, result)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `when lat and lng doesn't exist, should get null`() = runBlockingTest {

        //Given
        val lat = 48.8000000
        val lng = 2.38888888

        val response = null
        whenever(
            repository.getWeatherInfoFromLocal(
                lat,
                lng
            )
        )
            .thenReturn(response)

        //When
        val result = sut.execute(lat, lng)

        //Then
        assertEquals(null, result)
    }


}