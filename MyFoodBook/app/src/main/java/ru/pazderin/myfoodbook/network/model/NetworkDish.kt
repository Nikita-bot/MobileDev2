package ru.pazderin.myfoodbook.network.model

data class NetworkDish(
    var id:Int,
    var name:String,
    var ingridients:List<String>,
    var description:String,
    var author:Int,
    var cookTime:Int
)
