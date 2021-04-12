package com.example.shavyha_map.view_model

import androidx.lifecycle.MutableLiveData
import com.example.shavyha_map.data_source.database.entity.PlacesEntity
import com.example.shavyha_map.use_case.GetPlaceByIdUseCase
import io.reactivex.rxkotlin.plusAssign

class DetailViewModel(private val getPlaceByIdUseCase: GetPlaceByIdUseCase) : BaseViewModel(){

    val placeGetById =  MutableLiveData<PlacesEntity>()

    fun getPlaceById(id: Int){
        compositeDisposable += getPlaceByIdUseCase.getPlaceById(id)
            .subscribe { place ->
                placeGetById.value = place
            }
    }
}