package com.example.testapp

import android.app.Application
import com.example.testapp.di.AppComponent
import com.example.testapp.di.AppModule
import com.example.testapp.di.DaggerAppComponent

class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}