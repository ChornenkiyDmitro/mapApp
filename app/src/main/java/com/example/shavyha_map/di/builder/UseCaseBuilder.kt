package com.example.shavyha_map.di.builder

import com.example.shavyha_map.repository.PlacesRepository
import com.example.shavyha_map.use_case.*

class UseCaseBuilder {

    fun initDeleteTableUseCase(repository: PlacesRepository):
            DeleteTableUseCase = DeleteTableUseCaseImpl(repository)

    fun initGetAllPlacesUseCase(repository: PlacesRepository):
            GetAllPlacesUseCase = GetAllPlacesUseCaseImpl(repository)

    fun initGetPlaceByIdUseCase(repository: PlacesRepository):
            GetPlaceByIdUseCase = GetPlaceByIdUseCaseImpl(repository)

    fun initInsertPlaceUseCase(repository: PlacesRepository):
            InsertPlaceUseCase = InsertPlaceUseCaseImpl(repository)
}