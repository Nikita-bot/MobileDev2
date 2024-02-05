package ru.pazderin.myfoodbook.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.pazderin.myfoodbook.data.entity.Dish


@Composable
fun InfoScreen(item: Dish) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp)
    ){
        Item(item)
    }
}