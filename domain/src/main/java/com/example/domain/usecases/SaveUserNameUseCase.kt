package com.example.domain.usecases

import com.example.domain.models.SaveUserNameParam
import com.example.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        if (param.name.isEmpty())
            return false
        val oldUserName = userRepository.getName()
        if (oldUserName.firstName == param.name) {
            return true
        }
        return userRepository.saveName(param)
    }
}