package com.example.testapp.di

import com.example.data.repository.UserRepositoryImpl
import com.example.data.storage.UserStorage
import com.example.data.storage.sharedPrefs.SharedPrefsUserStorage
import com.example.domain.repository.UserRepository
import org.koin.dsl.module


val dataModule = module {

    single<UserStorage> {
        SharedPrefsUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }

}