package com.example.shavyha_map.use_case

import com.example.shavyha_map.data_source.database.entity.PlacesEntity
import com.example.shavyha_map.repository.PlacesRepository
import io.reactivex.Single

interface GetAllPlacesUseCase{
    fun getAllPlaces(): Single<List<PlacesEntity>>
}

class GetAllPlacesUseCaseImpl(private val placesRepository: PlacesRepository) : GetAllPlacesUseCase{
    override fun getAllPlaces(): Single<List<PlacesEntity>> {
        return placesRepository.getAllPlaces()
    }

}