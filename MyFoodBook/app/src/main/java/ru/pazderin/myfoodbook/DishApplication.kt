package ru.pazderin.myfoodbook

import android.app.Application
import ru.pazderin.myfoodbook.data.AppContainer
import ru.pazderin.myfoodbook.data.DefaultAppContainer

class DishApplication: Application() {
    lateinit var container:AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}