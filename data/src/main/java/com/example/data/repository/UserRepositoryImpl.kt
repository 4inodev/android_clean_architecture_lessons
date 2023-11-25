package com.example.data.repository

import com.example.data.storage.models.User
import com.example.data.storage.UserStorage
import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName
import com.example.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(param: SaveUserNameParam): Boolean {
        return userStorage.save(mapToStorage(param))
    }

    override fun getName(): UserName {
        return mapToDomain(userStorage.get())
    }

    private fun mapToStorage(saveUserNameParam: SaveUserNameParam): User {
        return User(
            firstName = saveUserNameParam.name,
            lastName = saveUserNameParam.name.reversed()
        )
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(user.firstName, user.lastName)
    }
}