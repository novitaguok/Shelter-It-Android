package com.novitaguok.shelterit.feature.auth.impl.register

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.novitaguok.shelterit.feature.auth.impl.register.model.RegisterUiEvent

@Composable
fun RegisterRoute(
    onNavigateBack: () -> Unit,
    onNavigateToSignIn: () -> Unit,
    onNavigateToHome: () -> Unit,
    onOpenGuidelines: () -> Unit,
    onOpenPrivacyPolicy: () -> Unit,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState.isRegistrationCompleted) {
        if (uiState.isRegistrationCompleted) onNavigateToHome()
    }

    LaunchedEffect(uiState.errorMsg) {
        val msg = uiState.errorMsg ?: return@LaunchedEffect

        snackbarHostState.showSnackbar(msg)
        viewModel.onEvent(RegisterUiEvent.OnErrorDismissed)
    }

    RegisterScreen(
        state = uiState,
        onEvent = viewModel::onEvent,
    )
}
