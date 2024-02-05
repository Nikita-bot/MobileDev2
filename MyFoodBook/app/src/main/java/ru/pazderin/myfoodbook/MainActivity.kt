package ru.pazderin.myfoodbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.pazderin.myfoodbook.ui.DishApp
import ru.pazderin.myfoodbook.ui.theme.MyFoodBookTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFoodBookTheme {
                DishApp()
            }
        }
    }
}








