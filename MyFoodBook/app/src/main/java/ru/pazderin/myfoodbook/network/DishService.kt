package ru.pazderin.myfoodbook.network

import retrofit2.http.GET
import retrofit2.http.POST
import ru.pazderin.myfoodbook.network.model.NetworkDish

interface DishService {

    @GET("all")
    suspend fun getAll():List<NetworkDish>

    @GET("favorite")
    suspend fun getFavorite():List<NetworkDish>


}