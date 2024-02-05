package ru.pazderin.myfoodbook.data

import ru.pazderin.myfoodbook.data.entity.UserToken
import ru.pazderin.myfoodbook.network.UserService

class UserRepository(
    private val userService: UserService
) {

    lateinit var user:UserToken

    suspend fun reg(email:String, pass:String):UserToken{
        user = UserToken(userService.registration(email,pass).token)
        return user
    }

    suspend fun auth(email:String, pass:String):UserToken{
        user = UserToken(userService.auth(email,pass).token)
        return user
    }

}