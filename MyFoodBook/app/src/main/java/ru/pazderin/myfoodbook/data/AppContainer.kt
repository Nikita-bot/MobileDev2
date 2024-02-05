package ru.pazderin.myfoodbook.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.pazderin.myfoodbook.network.DishService
import ru.pazderin.myfoodbook.network.UserService

//Внедрение зависимости
interface AppContainer {
    val dishRepository:DishRepository
    val userRepository:UserRepository
}

class DefaultAppContainer:AppContainer{
    private val BASE_URL = "https://localhost:8080/"

    private val retrofit:Retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build()

    private val retrofitDishService:DishService by lazy{
        retrofit.create(DishService::class.java)
    }

    private val retrofitUserService:UserService by lazy{
        retrofit.create(UserService::class.java)
    }

    override val dishRepository: DishRepository by lazy{
        DishRepository(retrofitDishService)
    }

    override val userRepository: UserRepository by lazy{
        UserRepository(retrofitUserService)
    }
}
