package com.example.testmvvm.injection.component

import com.example.testmvvm.injection.module.NetworkModule
import com.example.testmvvm.ui.SuperheroeListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(superheroeListViewModel: SuperheroeListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}