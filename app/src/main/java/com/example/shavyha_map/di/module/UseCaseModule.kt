package com.example.shavyha_map.di.module

import androidx.annotation.Keep
import com.example.shavyha_map.di.builder.UseCaseBuilder
import org.koin.dsl.module

@Keep
val useCaseModule = module {
    single { UseCaseBuilder() }
    single { get<UseCaseBuilder>().initDeleteTableUseCase(get()) }
    single { get<UseCaseBuilder>().initGetAllPlacesUseCase(get()) }
    single { get<UseCaseBuilder>().initGetPlaceByIdUseCase(get()) }
    single { get<UseCaseBuilder>().initInsertPlaceUseCase(get()) }
}