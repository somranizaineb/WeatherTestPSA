package com.example.lib.domain

import com.example.lib.data.repository.WeatherRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


/**
 * Created by zaineb on 27/07/2020
 */
@ExperimentalCoroutinesApi
class RetrieveFavoritesTownsFromLocalTest{

    private lateinit var sut: RetrieveFavoritesTownsFromLocal

    @Mock
    lateinit var repository: WeatherRepository


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        sut = RetrieveFavoritesTownsFromLocal(repository)
    }

    @Test
    fun `when use case is invoked, should get towns from repository` () = runBlockingTest {

        //When
        sut.execute()
        //Then verfily invocation
        Mockito.verify(repository).getFavoritesTownsFromLocal()
    }


}


