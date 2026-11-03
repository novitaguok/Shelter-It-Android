package com.novitaguok.shelterit.feature.auth.impl.register

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.novitaguok.shelterit.feature.auth.impl.register.model.RegisterUiEvent
import com.novitaguok.shelterit.feature.auth.impl.register.model.RegisterUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _uiState = MutableStateFlow(
        RegisterUiState(
            name = savedStateHandle[KEY_NAME] ?: "",
            email = savedStateHandle[KEY_EMAIL] ?: ""
        )
    )
    val uiState: StateFlow<RegisterUiState> = _uiState.asStateFlow()

    fun onEvent(event: RegisterUiEvent) {
        when (event) {
            is RegisterUiEvent.OnNameChanged -> {
                savedStateHandle[KEY_NAME] = event.value
                _uiState.update { it.copy(name = event.value) }
            }

            is RegisterUiEvent.OnEmailChanged -> {
                savedStateHandle[KEY_EMAIL] = event.value
                _uiState.update { it.copy(email = event.value) }
            }

            is RegisterUiEvent.OnPasswordChanged -> {
                _uiState.update { it.copy(password = event.value) }
            }

            RegisterUiEvent.OnTogglePasswordVisibility -> {
                _uiState.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
            }

            is RegisterUiEvent.OnTermsAcceptedChanged -> {
                _uiState.update { it.copy(isTermsAccepted = event.isAccepted) }
            }

            is RegisterUiEvent.OnSubmit -> submitRegistration()

            RegisterUiEvent.OnNavigateBack -> TODO()
            RegisterUiEvent.OnNavigateToSignIn -> TODO()
            RegisterUiEvent.OnOpenGuidelines -> TODO()
            RegisterUiEvent.OnOpenPrivacyPolicy -> TODO()
            RegisterUiEvent.OnErrorDismissed -> {
                _uiState.update { it.copy(errorMsg = null) }
            }
        }
    }

    private fun submitRegistration() {

    }

    private companion object {
        const val KEY_NAME = "register_name"
        const val KEY_EMAIL = "register_email"
    }
}
