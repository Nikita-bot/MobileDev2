package ru.pazderin.myfoodbook.network

import retrofit2.http.GET
import retrofit2.http.POST
import ru.pazderin.myfoodbook.network.model.User

interface UserService {
    @POST("reg")
    suspend fun registration(email:String,pass:String):User

    @GET("auth")
    suspend fun auth(email:String,pass:String):User

}