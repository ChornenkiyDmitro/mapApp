package com.example.shavyha_map.di.builder

import com.example.shavyha_map.remote_data_source.RemoteDataSource
import com.example.shavyha_map.remote_data_source.RemoteDataSourceImpl

class RemoteDatabaseBuilder {

    fun getRemoteDataSource(): RemoteDataSource = RemoteDataSourceImpl()
}