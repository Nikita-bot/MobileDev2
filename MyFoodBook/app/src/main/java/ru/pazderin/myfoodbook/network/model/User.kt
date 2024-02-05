package ru.pazderin.myfoodbook.network.model

data class User(
    val id:Int,
    val email:String,
    val pass:String,
    val token:String,
)
