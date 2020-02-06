package com.example.testmvvm

import androidx.lifecycle.ViewModel
import com.example.testmvvm.models.SuperheroeListViewModel
import com.example.testmvvm.module.injection.DaggerViewModelInjector
import com.example.testmvvm.module.injection.NetworkModule
import com.example.testmvvm.module.injection.ViewModelInjector


abstract class BaseViewModel: ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is SuperheroeListViewModel -> injector.inject(this)
        }
    }
}