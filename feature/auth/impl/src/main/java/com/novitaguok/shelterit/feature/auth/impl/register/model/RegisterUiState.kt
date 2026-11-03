package com.novitaguok.shelterit.feature.auth.impl.register.model

import androidx.compose.runtime.Immutable

@Immutable
class RegisterUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isTermsAccepted: Boolean = false,
    val isSubmitted: Boolean = false,
    val isLoading: Boolean = false,
) {
    val passwordStrength: PasswordStrength
        get() = PasswordStrength.of(password)

    val nameError: String?
        get() =
            if (isSubmitted && name.isBlank()) "Name is required."
            else null

    val emailError: String?
        get() = when {
            !isSubmitted -> null
            email.isBlank() -> "Email is required."
            !EmailRegex.matches(email.trim()) -> "Wrong email format."
            else -> null
        }

    val passwordError: String?
        get() = when {
            !isSubmitted -> null
            password.length < 8 -> "Password must be at least 8 characters"
            else -> null
        }

    val termsError: Boolean
        get() = isSubmitted && !isTermsAccepted

    val isValid: Boolean
        get() = name.isNotBlank() &&
                EmailRegex.matches(email.trim()) &&
                password.length >= 8 &&
                isTermsAccepted

    private companion object {
        val EmailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    }
}
