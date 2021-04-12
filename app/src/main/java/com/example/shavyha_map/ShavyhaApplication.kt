package com.example.shavyha_map

import android.app.Application
import com.example.shavyha_map.di.module.applicationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ShavyhaApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initDependencies()
    }

    private fun initDependencies() = startKoin {
        androidLogger()
        androidContext(this@ShavyhaApplication)
        modules(applicationModule)
    }
}
