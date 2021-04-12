package com.example.shavyha_map.di.module

import androidx.annotation.Keep
import com.example.shavyha_map.di.builder.RemoteDatabaseBuilder
import org.koin.dsl.module

@Keep
val remoteDatabaseModule = module {
    single { RemoteDatabaseBuilder() }
    single { get<RemoteDatabaseBuilder>().getRemoteDataSource() }
}