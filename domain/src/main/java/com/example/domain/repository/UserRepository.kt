package com.example.domain.repository

import com.example.domain.models.SaveUserNameParam
import com.example.domain.models.UserName

interface UserRepository {

    fun saveName(param: SaveUserNameParam): Boolean

    fun getName(): UserName

}