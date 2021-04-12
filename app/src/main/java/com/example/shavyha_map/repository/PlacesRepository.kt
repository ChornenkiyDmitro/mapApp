package com.example.shavyha_map.repository

import com.example.shavyha_map.data_source.DataSource
import com.example.shavyha_map.data_source.database.entity.PlacesEntity
import com.example.shavyha_map.remote_data_source.RemoteDataSource
import io.reactivex.Completable
import io.reactivex.Single

interface PlacesRepository{

    fun getAllPlaces(): Single<List<PlacesEntity>>
    fun getPlaceById(id: Int): Single<PlacesEntity>
    fun insertPlace(place: PlacesEntity): Completable
    fun deleteTable(): Completable
}

class PlacesRepositoryImpl(
    private val dataSource: DataSource,
    private val remoteDataSource: RemoteDataSource
) : PlacesRepository{
    override fun getAllPlaces(): Single<List<PlacesEntity>> {
       return dataSource.getAllPlaces()
    }

    override fun getPlaceById(id: Int): Single<PlacesEntity> {
        return dataSource.getPlaceById(id)
    }

    override fun insertPlace(place: PlacesEntity): Completable {
      return dataSource.insertPlace(place)
    }

    override fun deleteTable(): Completable {
        return dataSource.deleteTable()
    }
}