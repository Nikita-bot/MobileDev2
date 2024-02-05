package ru.pazderin.myfoodbook.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import retrofit2.HttpException
import ru.pazderin.myfoodbook.DishApplication
import ru.pazderin.myfoodbook.data.UserRepository

import ru.pazderin.myfoodbook.data.entity.UserToken
import java.io.IOException


sealed interface UserUiState{
    data class Success(var token:UserToken):UserUiState
    object Error:UserUiState
    object Loading:UserUiState
}


class UserViewModel(
    private val userRepository: UserRepository
):ViewModel() {
    var userUiState:UserUiState by mutableStateOf(UserUiState.Loading)
    private set

    fun reg(email:String, pass:String){
        viewModelScope.launch {
            userUiState = UserUiState.Loading
            try {
                UserUiState.Success(userRepository.reg(email,pass))
            }catch (e: IOException){
                UserUiState.Error
            }catch (e: HttpException){
                UserUiState.Error
            }
        }
    }

    fun auth(email: String, pass: String){
        viewModelScope.launch {
            userUiState = UserUiState.Loading
            try {
                UserUiState.Success(userRepository.auth(email,pass))
            }catch (e: IOException){
                UserUiState.Error
            }catch (e: HttpException){
                UserUiState.Error
            }
        }
    }

    companion object{

        val Factory: ViewModelProvider.Factory = viewModelFactory {

            initializer {

                val appliation = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as DishApplication)

                val userRepository = appliation.container.userRepository

                UserViewModel(userRepository = userRepository)

            }

        }

    }
}
