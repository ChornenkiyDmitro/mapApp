package com.example.shavyha_map.di.module

import androidx.annotation.Keep
import com.example.shavyha_map.di.builder.RepositoryBuilder
import org.koin.dsl.module

@Keep
val repositoryModule = module {
    single { RepositoryBuilder(get(), get()) }
    single { get<RepositoryBuilder>().initRepository() }
}