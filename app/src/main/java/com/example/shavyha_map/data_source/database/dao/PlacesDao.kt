package com.example.shavyha_map.data_source.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.shavyha_map.data_source.database.entity.PlacesEntity

@Dao
interface PlacesDao {
    @Query("SELECT * FROM places")
    fun getAllPlaces(): List<PlacesEntity>

    @Query("SELECT * FROM places WHERE id LIKE :id")
    fun getPlaceById(id: Int): PlacesEntity

    @Query("DELETE FROM places")
    fun deleteTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlace(place: PlacesEntity)
}