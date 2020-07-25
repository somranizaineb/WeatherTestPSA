package com.example.psatest.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.psatest.data.entities.Town

/**
 * Created by zaineb on 23/07/2020
 */
@Dao
interface TownDao {

    @Query("SELECT * FROM users")
    fun findAll(): LiveData<List<Town>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(towns: List<Town>)
}