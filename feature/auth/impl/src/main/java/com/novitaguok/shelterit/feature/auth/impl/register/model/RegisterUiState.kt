package com.novitaguok.shelterit.feature.auth.impl.register.model

import androidx.compose.runtime.Immutable

enum class EmailValidatorError {
    REQUIRED, INVALID_FORMAT
}

@Immutable
data class RegisterUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val isPasswordVisible: Boolean = false,
    val isTermsAccepted: Boolean = false,
    val isSubmitted: Boolean = false,
    val isLoading: Boolean = false,
    val errorMsg: String? = null,
    val isRegistrationCompleted: Boolean = false
) {
    private val trimmedName: String
        get() = name.trim()

    private val trimmedEmail: String
        get() = email.trim()

    val passwordStrength: PasswordStrength
        get() = PasswordStrength.of(password)

    val isNameError: Boolean
        get() = isSubmitted && trimmedName.isEmpty()

//    val nameError: String?
//        get() =
//            if (isSubmitted && trimmedName.isEmpty()) "Name is required."
//            else null

    val emailError: String?
        get() = when {
            !isSubmitted -> null
            trimmedEmail.isEmpty() -> "Email is required."
            !EmailRegex.matches(email.trim()) -> "Wrong email format."
            else -> null
        }

    val isPasswordError: Boolean
        get() = isSubmitted && password.length < MIN_PASSWORD_LENGTH

//    val passwordError: String?
//        get() = when {
//            !isSubmitted -> null
//            password.length < MIN_PASSWORD_LENGTH -> "Password must be at least $MIN_PASSWORD_LENGTH characters"
//            else -> null
//        }

    val isTermsError: Boolean
        get() = isSubmitted && !isTermsAccepted

    val isValid: Boolean
        get() = trimmedName.isNotEmpty() &&
                trimmedEmail.isNotEmpty() &&
                EmailRegex.matches(email.trim()) &&
                password.length >= MIN_PASSWORD_LENGTH &&
                isTermsAccepted

    private companion object {
        const val MIN_PASSWORD_LENGTH = 8
        val EmailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    }
}
