package com.novitaguok.shelterit.feature.auth.impl.register.model

enum class StrengthTone { Neutral, Error, Success }

enum class PasswordStrength(val label: String, val filledBars: Int, val tone: StrengthTone) {
    NONE("8+ characters", 0, StrengthTone.Neutral),
    WEAK("Weak", 1, StrengthTone.Error),
    GOOD("Good", 2, StrengthTone.Success),
    STRONG("Strong", 3, StrengthTone.Success);

    companion object {
        fun of(password: String): PasswordStrength {
            if (password.isEmpty()) return NONE
            val variety = listOf(
                password.any(Char::isDigit),
                password.any(Char::isUpperCase),
                password.any { !it.isLetterOrDigit() },
            ).count { it }

            return when {
                password.length >= 12 && variety >= 2 -> STRONG
                password.length >= 8 -> GOOD
                else -> WEAK
            }
        }
    }
}
