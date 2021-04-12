package com.example.shavyha_map.use_case

import com.example.shavyha_map.data_source.database.entity.PlacesEntity
import com.example.shavyha_map.repository.PlacesRepository
import io.reactivex.Single

interface GetPlaceByIdUseCase{
    fun getPlaceById(id: Int): Single<PlacesEntity>
}

class GetPlaceByIdUseCaseImpl(private val placesRepository: PlacesRepository): GetPlaceByIdUseCase{
    override fun getPlaceById(id: Int): Single<PlacesEntity> {
        return placesRepository.getPlaceById(id)
    }

}