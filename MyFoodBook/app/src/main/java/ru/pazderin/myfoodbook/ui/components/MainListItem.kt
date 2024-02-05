package ru.pazderin.myfoodbook.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.pazderin.myfoodbook.data.entity.Dish


@Composable
fun MainListItem(item: Dish, onClick:(Dish)->Unit) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(5.dp)
            .clickable {
                onClick(item)
            },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, Color.Red)
    ){
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            Text(
                text = item.title,
                modifier = Modifier.fillMaxWidth().background(Color.Red).padding(10.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,

            )
        }
    }
}