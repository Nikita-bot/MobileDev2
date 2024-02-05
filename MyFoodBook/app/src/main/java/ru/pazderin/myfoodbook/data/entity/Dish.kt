package ru.pazderin.myfoodbook.data.entity

data class Dish(
    val title:String,
    val ingridients:List<String>?,
    val description:String?,
    val cookTime:Int?
)
