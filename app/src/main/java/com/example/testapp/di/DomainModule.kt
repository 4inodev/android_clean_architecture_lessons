package com.example.testapp.di

import com.example.domain.usecases.GetUserNameUseCase
import com.example.domain.usecases.SaveUserNameUseCase
import org.koin.dsl.module

val domainModule = module {

    factory {
        GetUserNameUseCase(userRepository = get())
    }

    factory {
        SaveUserNameUseCase(userRepository = get())
    }
}