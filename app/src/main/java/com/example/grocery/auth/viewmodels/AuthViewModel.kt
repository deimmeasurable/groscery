package com.example.grocery.auth.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocery.auth.events.AuthEvent
import com.example.grocery.auth.general.util.Resource
import com.example.grocery.auth.request.LoginRequest
import com.example.grocery.auth.state.AuthState
import kotlinx.coroutines.flow.MutableSharedFlow


@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authenticationUsecases: AuthenticationUsecases
): ViewModel() {

    private val _eventFlow = MutableSharedFlow<AuthEvent>()
    val eventFlow = _eventFlow.asSharedFlow()
    private val _state = mutableStateOf(
        AuthState(
            isAuthenticated = false
        )
    )
    val state: State<AuthState> = _state

    fun createEvent(event: AuthEvent){
        onEvent(event)
    }

    private fun onEvent(event: AuthEvent) {
        when(event){
            is AuthEvent.Login ->{
                val request = LoginRequest(
                    email = event.email,
                    password = event.password
                )
                login(request= request)
            }
            else->{}
        }
    }

    private fun login(request: LoginRequest){
        authenticationUsecases.login(request = request)
            .onEach{
                when(it){
                    is Resource.Loading<*> ->{
                        _state.value = state.value.copy(
                            isLoading = true
                        )
                    }
                    is Resource.Error->{
                        val message=it.message
                    }
                    is Resource.Success<*> ->{
                        _state.value = state.value.copy(
                            isLoading = false
                        )
                        _eventFlow.emit(
                            AuthEvent.LoginSuccess
                        )
                    }
                }
            }.launchIn(viewModelScope)
    }

}