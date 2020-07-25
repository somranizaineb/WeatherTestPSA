package com.example.lib.di.modules
import android.content.Context
import androidx.room.Room
import com.example.lib.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
/**
 * Created by zaineb on 23/07/2020
 */
@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            AppDatabase.NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}
