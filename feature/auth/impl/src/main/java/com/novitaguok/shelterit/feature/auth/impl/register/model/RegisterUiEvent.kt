package com.novitaguok.shelterit.feature.auth.impl.register.model

sealed interface RegisterUiEvent {
    data class OnNameChanged(val value: String) : RegisterUiEvent
    data class OnEmailChanged(val value: String) : RegisterUiEvent
    data class OnPasswordChanged(val value: String) : RegisterUiEvent
    data object OnTogglePasswordVisibility : RegisterUiEvent
    data class OnTermsAcceptedChanged(val isAccepted: Boolean) : RegisterUiEvent
    data object OnSubmit : RegisterUiEvent
    data object OnNavigateBack : RegisterUiEvent
    data object OnNavigateToSignIn : RegisterUiEvent
    data object OnOpenGuidelines : RegisterUiEvent
    data object OnOpenPrivacyPolicy : RegisterUiEvent
}
