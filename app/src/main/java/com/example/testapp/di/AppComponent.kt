package com.example.testapp.di

import com.example.testapp.presentation.MainActivity
import dagger.Component

@Component(modules = [
    AppModule::class,
    DomainModule::class,
    DataModule::class,
    ViewModelFactoryModule::class
])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}