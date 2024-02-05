package ru.pazderin.myfoodbook.data.entity

import ru.pazderin.myfoodbook.utils.IdArrayList

//Универсальный класс, чтоб передавать дата классы между компонентами
sealed class DrawerEvents{
    data class OnItemClick(val title:String, val type: IdArrayList): DrawerEvents()
}
