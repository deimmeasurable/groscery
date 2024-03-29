package com.example.grocery.auth.viewmodels

import android.text.InputType
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.grocery.auth.events.LoginFormEvent
import com.example.grocery.auth.state.LoginFormState


@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    private val _state = mutableStateOf(LoginFormState())
    val state: State<LoginFormState> = _state

    fun createEvent(event: LoginFormEvent){
        onEvent(event)
    }


    private fun onEvent(event: LoginFormEvent) {
        when(event){
            is LoginFormEvent.EnteredEmail ->{
                _state.value = state.value.copy(
                    email = event.value
                )
            }
            is LoginFormEvent.EnteredPassword ->{
                _state.value = state.value.copy(
                    password = event.value
                )
            }
            is LoginFormEvent.FocusChange ->{
                when(event.focusFieldName){
                    "email" -> {
                        val validity = validateInput(
                            inputValue = state.value.email,
                            inputType = InputType.TEXT
                        )
                        val  inputValid = validity.first

                        if (!inputValid){
                            val errorMessage = validity.second
                            _state.value = state.value.copy(
                                emailValid = false,
                                emailErrorMessage = errorMessage,
                                formValid = false
                            )
                        }
                    }

                    "password" -> {
                        val validity = validateInput(
                            inputValue = state.value.password,
                            inputType = InputType.PASSWORD
                        )
                        val  inputValid = validity.first

                        if (!inputValid){
                            val errorMessage = validity.second
                            _state.value = state.value.copy(
                                passwordValid = false,
                                emailErrorMessage = errorMessage,
                                formValid = false
                            )
                        }
                    }
                }
            }
        }
    }
}