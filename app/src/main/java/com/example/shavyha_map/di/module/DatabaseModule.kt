package com.example.shavyha_map.di.module

import androidx.annotation.Keep
import com.example.shavyha_map.di.builder.DataBaseBuilder
import org.koin.dsl.module

@Keep
val databaseModule = module {
    single { DataBaseBuilder(get()) }
    single { get<DataBaseBuilder>().initDatabase() }
    single { get<DataBaseBuilder>().getDataSource(get()) }
}