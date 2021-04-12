package com.example.shavyha_map.use_case

import com.example.shavyha_map.repository.PlacesRepository
import io.reactivex.Completable

interface DeleteTableUseCase{
    fun deleteTable(): Completable
}

class DeleteTableUseCaseImpl(private val placesRepository: PlacesRepository) : DeleteTableUseCase{
    override  fun deleteTable(): Completable {
        return placesRepository.deleteTable()
    }

}