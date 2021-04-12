package com.example.shavyha_map.view_model

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: ViewModel() {
    protected val compositeDisposable = CompositeDisposable()
    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}