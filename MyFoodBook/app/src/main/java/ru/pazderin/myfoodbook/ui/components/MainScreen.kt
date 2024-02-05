package ru.pazderin.myfoodbook.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import ru.pazderin.myfoodbook.data.entity.Dish
import ru.pazderin.myfoodbook.data.entity.DrawerEvents
import ru.pazderin.myfoodbook.ui.DishUiState
import ru.pazderin.myfoodbook.ui.DishViewModel
import ru.pazderin.myfoodbook.utils.IdArrayList


@Composable
fun MainScreen(dishViewModel: DishViewModel, onClick:(Dish)->Unit, retryAction:()->Unit) {
        val scaffoldState = rememberScaffoldState()
        val coroutine = rememberCoroutineScope()
        val state = dishViewModel.dishUiState
        val topBarTitle = remember {
            mutableStateOf("Все Блюда")
        }
        when(state){
            is DishUiState.Loading -> LoadScreen()
            is DishUiState.Error ->ErrorScreen(retryAction = retryAction)
            is DishUiState.Success -> Scaffold(
                topBar = {
                    MainTopBar(
                        title = topBarTitle.value,
                        scaffoldState = scaffoldState
                    )
                },
                drawerContent = { DrawerMenu{ event->
                    when(event){
                        is DrawerEvents.OnItemClick->{
                            topBarTitle.value = event.title
                            when(event.type){
                                IdArrayList.LIST_ALL -> dishViewModel.getDishes()
                                IdArrayList.LIST_FAVORITE -> dishViewModel.getFavorite()
                            }
                        }
                    }

                    coroutine.launch {
                        scaffoldState.drawerState.close()
                    }
                    }
                }
        ){
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(state.listDish){ item->
                    MainListItem(item = item){
                        listItem -> onClick(listItem)
                    }
                }
            }
        }
    }


}
