package com.example.lib.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lib.data.local.AppDatabase.Companion.VERSION
import com.example.psatest.data.entities.Town

/**
 * Created by zaineb on 23/07/2020
 */
@Database(entities = [Town::class], version = VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val VERSION = 2
        const val NAME = "digitu.db"
    }

}