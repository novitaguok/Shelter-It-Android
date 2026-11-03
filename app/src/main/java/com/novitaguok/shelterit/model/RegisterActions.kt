package com.novitaguok.shelterit.model

import androidx.compose.runtime.Immutable

@Immutable
data class RegisterActions(
    val onNavigateBack: () -> Unit = {},
    val onNavigateToSignIn: () -> Unit = {},
    val onOpenGuidelines: () -> Unit = {},
    val onOpenPrivacyPolicy: () -> Unit = {},
)
