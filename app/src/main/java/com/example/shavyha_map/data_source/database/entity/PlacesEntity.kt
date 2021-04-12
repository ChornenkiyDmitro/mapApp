package com.example.shavyha_map.data_source.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "places")
data class PlacesEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "place_name")
    val placeName: String,

    @ColumnInfo(name = "country")
    val country: String,

    @ColumnInfo(name = "city")
    val city: String,

    @ColumnInfo(name = "street")
    val street: String,

    @ColumnInfo(name = "latitude")
    val latitude: Double,

    @ColumnInfo(name = "longitude")
    val longitude: Double
)