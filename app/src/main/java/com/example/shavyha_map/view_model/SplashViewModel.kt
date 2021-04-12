package com.example.shavyha_map.view_model

import androidx.lifecycle.MutableLiveData
import com.example.shavyha_map.data_source.database.entity.PlacesEntity
import com.example.shavyha_map.use_case.DeleteTableUseCase
import com.example.shavyha_map.use_case.InsertPlaceUseCase
import io.reactivex.rxkotlin.plusAssign

class SplashViewModel (
    private val insertPlaceUseCase: InsertPlaceUseCase,
    private val deleteTableUseCase: DeleteTableUseCase
): BaseViewModel(){

    private val addingPlace = MutableLiveData<MainNextScreen>()
    private val errorMessage = MutableLiveData<String>()

    enum class MainNextScreen{
        DEFAULT, LIST_ACTIVITY
    }

    fun deleteTable(){
        compositeDisposable += deleteTableUseCase.deleteTable()
            .subscribe()
    }

    fun insertPlace(place : PlacesEntity){
        compositeDisposable += insertPlaceUseCase.insertPlace(place)

            .subscribe({
                addingPlace.value = MainNextScreen.LIST_ACTIVITY
            }, {error ->
            addingPlace.value = MainNextScreen.DEFAULT
            errorMessage.value = error.message
        })
    }
}

