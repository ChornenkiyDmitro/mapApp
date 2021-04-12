package com.example.shavyha_map.di.module

import androidx.annotation.Keep

@Keep
val applicationModule = listOf(
    databaseModule,
    remoteDatabaseModule,
    repositoryModule,
    useCaseModule,
    viewModelModule
)