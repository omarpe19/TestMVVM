package com.example.testmvvm.base

import androidx.lifecycle.ViewModel
import com.example.testmvvm.ui.SuperheroeListViewModel
import com.example.testmvvm.injection.component.DaggerViewModelInjector
import com.example.testmvvm.injection.module.NetworkModule
import com.example.testmvvm.injection.component.ViewModelInjector


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