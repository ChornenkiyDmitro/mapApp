package com.example.shavyha_map.use_case

import com.example.shavyha_map.data_source.database.entity.PlacesEntity
import com.example.shavyha_map.repository.PlacesRepository
import io.reactivex.Completable


interface InsertPlaceUseCase{
    fun insertPlace(place: PlacesEntity): Completable
}

class InsertPlaceUseCaseImpl(private val placesRepository: PlacesRepository) : InsertPlaceUseCase {
    override fun insertPlace(place: PlacesEntity): Completable {
        return placesRepository.insertPlace(place)
    }
}
