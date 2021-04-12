package com.example.shavyha_map.data_source

import com.example.shavyha_map.data_source.database.AppDataBase
import com.example.shavyha_map.data_source.database.entity.PlacesEntity
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface DataSource {

    fun getAllPlaces(): Single<List<PlacesEntity>>
    fun getPlaceById(id: Int): Single<PlacesEntity>
    fun insertPlace(place: PlacesEntity): Completable
    fun deleteTable(): Completable
}

class DataSourceImpl(private val dataBase: AppDataBase) : DataSource{
    override fun getAllPlaces(): Single<List<PlacesEntity>> {
        return Single.just(dataBase.getPlacesDao().getAllPlaces())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun getPlaceById(id: Int): Single<PlacesEntity> {
        return Single.just(dataBase.getPlacesDao().getPlaceById(id))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun insertPlace(place: PlacesEntity): Completable {
        return Completable.fromAction { dataBase.getPlacesDao().insertPlace(place)}
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun deleteTable(): Completable {
        return Completable.fromAction { dataBase.getPlacesDao().deleteTable() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}