package ru.pazderin.myfoodbook.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.pazderin.myfoodbook.data.entity.Dish
import ru.pazderin.myfoodbook.ui.components.MainScreen
import ru.pazderin.myfoodbook.ui.theme.MyFoodBookTheme
import ru.pazderin.myfoodbook.ui.components.InfoScreen
import ru.pazderin.myfoodbook.ui.components.LoginScreen
import ru.pazderin.myfoodbook.ui.components.RegScreen
import ru.pazderin.myfoodbook.utils.ActivityRoutes


@Composable
fun DishApp() {
    val dishViewModel:DishViewModel = viewModel(factory = DishViewModel.Factory)
    val userViewModel:UserViewModel = viewModel(factory = UserViewModel.Factory)
    val navController = rememberNavController()
    var item : Dish? = null

    MyFoodBookTheme {
        NavHost(
            navController = navController,
            startDestination = ActivityRoutes.AUTH_SCREEN
        ){
            composable(ActivityRoutes.MAIN_SCREEN){
                MainScreen(dishViewModel = dishViewModel, onClick = {listItem ->
                    item = listItem
                    navController.navigate(ActivityRoutes.INFO_SCREEN)
                }, retryAction = {dishViewModel.getDishes()})

            }
            composable(ActivityRoutes.INFO_SCREEN){
                InfoScreen(item = item!!)
            }
            composable(ActivityRoutes.AUTH_SCREEN){
                LoginScreen (
                    onLoginSuccess = {navController.navigate(ActivityRoutes.MAIN_SCREEN)},
                    onClickRegistration = {navController.navigate(ActivityRoutes.REG_SCREEN)},
                    userViewModel = userViewModel
                )
            }
            composable(ActivityRoutes.REG_SCREEN){
                RegScreen(userViewModel = userViewModel,
                onRegistrationSuccess =  {
                    navController.navigate(ActivityRoutes.MAIN_SCREEN)
                }
                )

            }
        }
    }
}