package com.example.lib.domain

import com.example.lib.common.whenever
import com.example.lib.data.remote.response.model.WeatherTownResponse
import com.example.lib.data.repository.WeatherRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by zaineb on 28/07/2020
 */
class GetWeatherByTownTest {

    private lateinit var sut: GetWeatherByTown

    @Mock
    lateinit var repository: WeatherRepository


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sut = GetWeatherByTown(repository)
    }


    @ExperimentalCoroutinesApi
    @Test
    fun `when lat and are double, should get not null`() = runBlockingTest {

        //Given
        val lat = 48.85
        val lng = 2.35
        val exclude = "minutely,hourly"
        val key = "39df4d2213f72ea35fcfcf89100d61ab"
        val units = "metric"
        val lang = "en"

        val response = WeatherTownResponse()
        whenever(
            repository.getWeatherTown(
                lat,
                lng,
                exclude,
                key,
                units,
                lang
            )
        )
            .thenReturn(response)

        val result = sut.execute(lat, lng)

        //Then
        assertNotEquals(null,  result)

    }

}

