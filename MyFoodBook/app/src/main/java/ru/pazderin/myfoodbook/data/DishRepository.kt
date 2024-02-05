package ru.pazderin.myfoodbook.data

import android.content.Context
import ru.pazderin.myfoodbook.R
import ru.pazderin.myfoodbook.data.entity.Dish
import ru.pazderin.myfoodbook.network.DishService
import ru.pazderin.myfoodbook.utils.IdArrayList



class DishRepository(
    private val dishService: DishService
) {
    var listDish:List<Dish> = listOf()
    var favoriteDish:List<Dish> = listOf()

     suspend fun getAll():List<Dish>{
        listDish = dishService.getAll().map{items->
            Dish(
                title = items.name,
                ingridients = items.ingridients,
                description = items.description,
                cookTime = items.cookTime
            )
        }
        return listDish
    }

     suspend fun getFavorite() :List<Dish>{
        favoriteDish = dishService.getFavorite().map{items->
            Dish(
                title = items.name,
                ingridients = items.ingridients,
                description = items.description,
                cookTime = items.cookTime
            )
        }
        return favoriteDish
    }



}