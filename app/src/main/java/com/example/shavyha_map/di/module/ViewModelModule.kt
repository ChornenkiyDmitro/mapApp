package com.example.shavyha_map.di.module

import androidx.annotation.Keep
import com.example.shavyha_map.view_model.DetailViewModel
import com.example.shavyha_map.view_model.MainViewModel
import com.example.shavyha_map.view_model.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

@Keep
val viewModelModule = module(override = true) {
    viewModel { DetailViewModel(get()) }
    viewModel { SplashViewModel(get(), get()) }
    viewModel { MainViewModel(get()) }
}