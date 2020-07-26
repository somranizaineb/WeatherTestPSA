package com.example.lib.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.lib.data.entities.Town

/**
 * Created by zaineb on 23/07/2020
 */
@Dao
interface TownDao {

    @Query("SELECT * FROM towns")
    suspend fun findAll(): List<Town>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(town: Town)
}