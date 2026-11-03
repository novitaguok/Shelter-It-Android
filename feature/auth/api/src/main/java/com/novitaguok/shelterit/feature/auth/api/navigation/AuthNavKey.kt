package com.novitaguok.shelterit.feature.auth.api.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface AuthNavKey : NavKey

@Serializable
data object RegisterKey : NavKey

@Serializable
data object LoginKey : NavKey

@Serializable
data object GuidelinesKey : NavKey

@Serializable
data object PrivacyPolicyKey : NavKey
