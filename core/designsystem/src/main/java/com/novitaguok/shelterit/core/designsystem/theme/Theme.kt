package com.novitaguok.shelterit.core.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    primaryContainer = LightPrimaryContainer,
    onPrimaryContainer = LightOnPrimaryContainer,
    inversePrimary = DarkPrimary,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    secondaryContainer = LightSecondaryContainer,
    onSecondaryContainer = LightOnSecondaryContainer,
    tertiary = LightTertiary,
    onTertiary = LightOnTertiary,
    tertiaryContainer = LightTertiaryContainer,
    onTertiaryContainer = LightOnTertiaryContainer,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceHigh,
    onSurfaceVariant = LightOnSurfaceVariant,
    surfaceContainerLowest = LightBackground,
    surfaceContainerLow = LightSurfaceLow,
    surfaceContainer = LightSurface,
    surfaceContainerHigh = LightSurfaceHigh,
    surfaceContainerHighest = LightSurfaceHigh,
    surfaceDim = LightSurfaceHigh,
    surfaceBright = LightSurfaceHigh,
    inverseSurface = DarkSurface,
    inverseOnSurface = DarkOnSurface,
    outline = LightOutline,
    outlineVariant = LightOutlineVariant,
    error = LightError,
    onError = LightOnError,
    errorContainer = LightErrorContainer,
    onErrorContainer = LightOnErrorContainer,
    scrim = Scrim,
    surfaceTint = LightPrimary,
)

private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkPrimaryContainer,
    onPrimaryContainer = DarkOnPrimaryContainer,
    inversePrimary = LightPrimary,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    secondaryContainer = DarkSecondaryContainer,
    onSecondaryContainer = DarkOnSecondaryContainer,
    tertiary = DarkTertiary,
    onTertiary = DarkOnTertiary,
    tertiaryContainer = DarkTertiaryContainer,
    onTertiaryContainer = DarkOnTertiaryContainer,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceHigh,
    onSurfaceVariant = DarkOnSurfaceVariant,
    surfaceContainerLowest = DarkBackground,
    surfaceContainerLow = DarkSurfaceLow,
    surfaceContainer = DarkSurface,
    surfaceContainerHigh = DarkSurfaceHigh,
    surfaceContainerHighest = DarkSurfaceHigh,
    surfaceDim = DarkSurfaceHigh,
    surfaceBright = DarkSurfaceHigh,
    inverseSurface = LightSurface,
    inverseOnSurface = LightOnSurface,
    outline = DarkOutline,
    outlineVariant = DarkOutlineVariant,
    error = DarkError,
    onError = DarkOnError,
    errorContainer = DarkErrorContainer,
    onErrorContainer = DarkOnErrorContainer,
    scrim = Scrim,
    surfaceTint = DarkPrimary,
)

// Roles Material 3 has no slot for (success family, app-bar surface, brand gradient).
@Immutable
data class ExtendedColors(
    val success: Color,
    val successContainer: Color,
    val onSuccessContainer: Color,
    val surfaceBar: Color,
    val heroGradient: Brush,
)

private val LightExtendedColors = ExtendedColors(
    success = LightSuccess,
    successContainer = LightSuccessContainer,
    onSuccessContainer = LightOnSuccessContainer,
    surfaceBar = LightSurfaceBar,
    heroGradient = Brush.verticalGradient(listOf(LightGradientA, LightGradientB)),
)

private val DarkExtendedColors = ExtendedColors(
    success = DarkSuccess,
    successContainer = DarkSuccessContainer,
    onSuccessContainer = DarkOnSuccessContainer,
    surfaceBar = DarkSurfaceBar,
    heroGradient = Brush.verticalGradient(listOf(DarkGradientA, DarkGradientB)),
)

val LocalExtendedColors = staticCompositionLocalOf { LightExtendedColors }

object ShelterItTheme {
    val extendedColors: ExtendedColors
        @Composable get() = LocalExtendedColors.current
}

@Composable
fun ShelterItTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(
        LocalExtendedColors provides if (darkTheme) DarkExtendedColors else LightExtendedColors,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = ShelterItTypography,
            shapes = ShelterItShapes,
            content = content,
        )
    }
}
