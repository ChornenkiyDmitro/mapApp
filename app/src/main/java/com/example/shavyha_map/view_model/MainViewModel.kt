package com.example.shavyha_map.view_model

import androidx.lifecycle.MutableLiveData
import com.example.shavyha_map.data_source.database.entity.PlacesEntity
import com.example.shavyha_map.use_case.DeleteTableUseCase
import com.example.shavyha_map.use_case.GetAllPlacesUseCase
import io.reactivex.rxkotlin.plusAssign

class MainViewModel(
    private val getAllPlacesUseCase: GetAllPlacesUseCase
) : BaseViewModel(){

    val allPlaces = MutableLiveData<List<PlacesEntity>>()

    fun getAllPlaces(){
        compositeDisposable += getAllPlacesUseCase.getAllPlaces()
            .subscribe{ list ->
                allPlaces.value = list
            }
    }
}