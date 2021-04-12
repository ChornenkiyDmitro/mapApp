package com.example.shavyha_map.presentation.main.places.adapter

import com.example.shavyha_map.data_source.database.entity.PlacesEntity

interface ListItemListener {
    fun onPlaceClick(place: PlacesEntity)
}