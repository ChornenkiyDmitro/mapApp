package com.example.shavyha_map.di.builder

import android.content.Context
import androidx.room.Room
import com.example.shavyha_map.data_source.DataSource
import com.example.shavyha_map.data_source.DataSourceImpl
import com.example.shavyha_map.data_source.database.AppDataBase

class DataBaseBuilder (private val context: Context){



    fun initDatabase(): AppDataBase = Room.databaseBuilder(
        context,
        AppDataBase::class.java,
        "place_database"
    )
        .allowMainThreadQueries()
        .build()

    fun getDataSource(dataBase: AppDataBase): DataSource = DataSourceImpl(dataBase)
}