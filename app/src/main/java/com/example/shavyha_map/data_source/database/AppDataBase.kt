package com.example.shavyha_map.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.shavyha_map.data_source.database.dao.PlacesDao
import com.example.shavyha_map.data_source.database.entity.PlacesEntity

@Database(entities = [PlacesEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun getPlacesDao(): PlacesDao
}