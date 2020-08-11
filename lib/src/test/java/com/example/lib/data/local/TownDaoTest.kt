package com.example.lib.data.local

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.lib.data.entities.Town
import com.example.lib.data.local.dao.TownDao
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.spy

class TownDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var townDao: TownDao

    @Mock
    lateinit var database: AppDatabase

    private val townA = Town("A", "A",0.0,0.0)
    private val townB = Town("B","B",0.0,0.0)
    private val townC = Town("C", "C",0.0,0.0)



    @Before
    fun setUp() {
        townDao = spy(database.townDao)
    }

    @Test
    fun test_getTowns()= runBlocking {
        // Given
        townDao.insert(townC)
        townDao.insert(townB)
        townDao.insert(townA)

        //When
        val townList = townDao.findAll()

        //Then
        assertEquals(townList.size,3)

        // Ensure plant list is sorted by name
        assertEquals(townList[0], townA)
        assertEquals(townList[1], townB)
        assertEquals(townList[2], townC)


    }



}