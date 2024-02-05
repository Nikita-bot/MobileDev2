package ru.pazderin.myfoodbook.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.pazderin.myfoodbook.R
import ru.pazderin.myfoodbook.data.entity.DrawerEvents
import ru.pazderin.myfoodbook.utils.IdArrayList


@Composable
fun DrawerMenu(onEvent:(DrawerEvents)->Unit) {
    Body(){
        event -> onEvent(event)
    }
}

@Composable
fun Body(onEvent:(DrawerEvents)->Unit){
    val list = stringArrayResource(id = R.array.drawer_list)
    LazyColumn(modifier = Modifier.fillMaxSize()){
        itemsIndexed(list){
            index, title ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp),
                backgroundColor = Color.Black
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            when(index){
                                IdArrayList.LIST_ALL.value -> onEvent(DrawerEvents.OnItemClick(title,IdArrayList.LIST_ALL))
                                IdArrayList.LIST_FAVORITE.value -> onEvent(DrawerEvents.OnItemClick(title,IdArrayList.LIST_FAVORITE))
                            }
                        }
                        .padding(10.dp)
                        .wrapContentWidth(),
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}