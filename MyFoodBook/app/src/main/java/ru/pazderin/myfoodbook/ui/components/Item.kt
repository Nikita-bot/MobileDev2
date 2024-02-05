package ru.pazderin.myfoodbook.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import ru.pazderin.myfoodbook.data.entity.Dish



@Composable
fun Item(list: Dish) {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Header(list)
        Ingridients(list)
        Description(list)
    }
}

@Composable
fun Header(list: Dish){
    Text(
        text = list.title,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun Ingridients(list: Dish){
    var arrayList = arrayListOf(list.title,list.title,list.title)
    Card() {
        Column() {
            arrayList.forEach {
                    item->
                Text(text = item)
            }
                
        }
        }
}



@Composable
fun Description(list: Dish){
    Text(
        text = list.title,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
    )
}