package com.example.shavyha_map.di.builder

import com.example.shavyha_map.data_source.DataSource
import com.example.shavyha_map.remote_data_source.RemoteDataSource
import com.example.shavyha_map.repository.PlacesRepository
import com.example.shavyha_map.repository.PlacesRepositoryImpl

class RepositoryBuilder(
    private val dataSource: DataSource,
    private val remoteDataSource: RemoteDataSource
) {
    fun initRepository(): PlacesRepository = PlacesRepositoryImpl(dataSource, remoteDataSource)
}