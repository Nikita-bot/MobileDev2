package ru.pazderin.myfoodbook.ui

import android.provider.ContactsContract.CommonDataKinds.Email
import android.text.Spannable.Factory
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import retrofit2.HttpException
import ru.pazderin.myfoodbook.DishApplication
import ru.pazderin.myfoodbook.data.DishRepository
import ru.pazderin.myfoodbook.data.UserRepository
import ru.pazderin.myfoodbook.data.entity.Dish
import ru.pazderin.myfoodbook.data.entity.UserToken
import java.io.IOException

//Основная идея заключается в том, что sealed class позволяет определить ограниченный и известный заранее набор подклассов, которые могут быть использованы.
//Конструктор изолированного класса всегда приватен, и это нельзя изменить.
sealed interface DishUiState{
    data class Success(var listDish:List<Dish>):DishUiState
    object Error:DishUiState
    object Loading:DishUiState
}

class DishViewModel(
    private val dishRepository: DishRepository,
):ViewModel() {

    var dishUiState:DishUiState by mutableStateOf(DishUiState.Loading)
    private set

    init {
        getDishes()
    }

    fun getDishes(){
        viewModelScope.launch {
            dishUiState = DishUiState.Loading
            dishUiState = try {
                DishUiState.Success(dishRepository.getAll())
            }catch (e: IOException){
                DishUiState.Error
            }catch (e:HttpException){
                DishUiState.Error
            }
        }
    }

    fun getFavorite(){
        viewModelScope.launch {
            dishUiState = DishUiState.Loading
            dishUiState = try {
                DishUiState.Success(dishRepository.getFavorite())
            }catch (e: IOException){
                DishUiState.Error
            }catch (e:HttpException){
                DishUiState.Error
            }
        }
    }

    //Оодин экземпляр объекта, который используется всеми без необходимости создавать новый экземпляр
    companion object{

        val Factory: ViewModelProvider.Factory = viewModelFactory {

            initializer {

                val appliation = (this[APPLICATION_KEY] as DishApplication)

                val dishRepository = appliation.container.dishRepository

                DishViewModel(dishRepository = dishRepository)

            }

        }

    }
}