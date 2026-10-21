package com.novitaguok.shelterit.ui.theme

import androidx.compose.ui.graphics.Color

// ---------- Light scheme · accents ----------
internal val LightPrimary = Color(0xFF9C4A10) // primary · Orange 40
internal val LightOnPrimary = Color(0xFFFFFFFF) // on-primary · Orange 100
internal val LightPrimaryContainer = Color(0xFFFFDBCC) // primary-container · Orange 90
internal val LightOnPrimaryContainer = Color(0xFF351000) // on-primary-container · Orange 10

internal val LightSecondary = Color(0xFF1F4B49) // secondary · Teal 30
internal val LightOnSecondary = Color(0xFFFFFFFF) // on-secondary · Teal 100
internal val LightSecondaryContainer = Color(0xFFA2F0E9) // secondary-container · Teal 90
internal val LightOnSecondaryContainer = Color(0xFF00201E) // on-secondary-container · Teal 10

internal val LightTertiary = Color(0xFF9C3152) // tertiary · Pink 40
internal val LightOnTertiary = Color(0xFFFFFFFF) // on-tertiary · Pink 100
internal val LightTertiaryContainer = Color(0xFFFFD9E4) // tertiary-container · Pink 90
internal val LightOnTertiaryContainer = Color(0xFF3E0721) // on-tertiary-container · Pink 10

internal val LightError = Color(0xFFBA1A1A) // error · Red 40
internal val LightOnError = Color(0xFFFFFFFF) // on-error · Red 100
internal val LightErrorContainer = Color(0xFFFFDAD6) // error-container · Red 90
internal val LightOnErrorContainer = Color(0xFF410002) // on-error-container · Red 10

// ---------- Light scheme · neutrals ----------
internal val LightBackground = Color(0xFFFFF8F2) // bg · Neutral 99
internal val LightOnBackground = Color(0xFF201B17) // on-surface · Neutral 10
internal val LightSurface = Color(0xFFF5EAE0) // surface · Neutral 95
internal val LightSurfaceLow = Color(0xFFFBF1E8) // surface-low · Neutral 95
internal val LightSurfaceHigh = Color(0xFFF0E2D6) // surface-high · Neutral 90
internal val LightOnSurface = Color(0xFF201B17) // on-surface · Neutral 10
internal val LightOnSurfaceVariant = Color(0xFF52443B) // on-surface-variant · Neutral 30
internal val LightOutline = Color(0xFF857360) // outline · Neutral Variant 50
internal val LightOutlineVariant = Color(0xFFD7C2B4) // outline-variant · Neutral Variant 80

// ---------- Dark scheme · accents ----------
internal val DarkPrimary = Color(0xFFFFB693) // primary · Orange 80
internal val DarkOnPrimary = Color(0xFF551F00) // on-primary · Orange 20
internal val DarkPrimaryContainer = Color(0xFF7A3504) // primary-container · Orange 30
internal val DarkOnPrimaryContainer = Color(0xFFFFDBCC) // on-primary-container · Orange 90

internal val DarkSecondary = Color(0xFF86D5CE) // secondary · Teal 80
internal val DarkOnSecondary = Color(0xFF003734) // on-secondary · Teal 20
internal val DarkSecondaryContainer = Color(0xFF1F4B49) // secondary-container · Teal 30
internal val DarkOnSecondaryContainer = Color(0xFFA2F0E9) // on-secondary-container · Teal 90

internal val DarkTertiary = Color(0xFFFFB1C8) // tertiary · Pink 80
internal val DarkOnTertiary = Color(0xFF5E1133) // on-tertiary · Pink 20
internal val DarkTertiaryContainer = Color(0xFF7B2949) // tertiary-container · Pink 30
internal val DarkOnTertiaryContainer = Color(0xFFFFD9E4) // on-tertiary-container · Pink 90

internal val DarkError = Color(0xFFFFB4AB) // error · Red 80
internal val DarkOnError = Color(0xFF690005) // on-error · Red 20
internal val DarkErrorContainer = Color(0xFF93000A) // error-container · Red 30
internal val DarkOnErrorContainer = Color(0xFFFFDAD6) // on-error-container · Red 90

// ---------- Dark scheme · neutrals ----------
internal val DarkBackground = Color(0xFF1C1310) // bg · Neutral 10
internal val DarkOnBackground = Color(0xFFEFE0D6) // on-surface · Neutral 90
internal val DarkSurface = Color(0xFF2E221C) // surface · Neutral 10
internal val DarkSurfaceLow = Color(0xFF261B16) // surface-low · Neutral 10
internal val DarkSurfaceHigh = Color(0xFF3A2C25) // surface-high · Neutral 20
internal val DarkOnSurface = Color(0xFFEFE0D6) // on-surface · Neutral 90
internal val DarkOnSurfaceVariant = Color(0xFFD7C2B4) // on-surface-variant · Neutral 80
internal val DarkOutline = Color(0xFF9F8D80) // outline · Neutral Variant 60
internal val DarkOutlineVariant = Color(0xFF52443B) // outline-variant · Neutral Variant 30

// ---------- Roles outside Material's color scheme ----------
internal val LightSuccess = Color(0xFF2E6B34) // success · Green 40
internal val LightSuccessContainer = Color(0xFFC9F2C9) // success-container · Green 90
internal val LightOnSuccessContainer = Color(0xFF0F2E12) // on-success-container · Green 20

internal val DarkSuccess = Color(0xFF9CD69A) // success · Green 80
internal val DarkSuccessContainer = Color(0xFF1E3D24) // success-container · Green 20
internal val DarkOnSuccessContainer = Color(0xFFC9F2C9) // on-success-container · Green 90

// Translucent app-bar surface: light #F5EAE0 @ 80% · dark #2E221C @ 72%
internal val LightSurfaceBar = Color(0xCCF5EAE0)
internal val DarkSurfaceBar = Color(0xB82E221C)

// Brand gradient "Apricot -> Honey" (light) / "Dusk -> Midnight" (dark)
internal val LightGradientA = Color(0xFFFFE3CF)
internal val LightGradientB = Color(0xFFFFC9A8)
internal val DarkGradientA = Color(0xFF312012)
internal val DarkGradientB = Color(0xFF150E08)

// Warm scrim used for overlays/dialog scrims (shared by both schemes)
internal val Scrim = Color(0xFF150E08)
