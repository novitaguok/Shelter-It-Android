package com.novitaguok.shelterit.core.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

// Radius tokens: radius-s 8 · radius-m 12 · radius-l 16 · radius-xl 28
internal val ShelterItShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(28.dp),
    extraLarge = RoundedCornerShape(28.dp),
)

// Spacing tokens (Material has no slot for these - use directly in layouts)
object ShelterItSpacing {
    val spaceXs = 4.dp
    val spaceSm = 8.dp
    val spaceMd = 12.dp
    val spaceL = 16.dp
    val spaceXl = 24.dp
    val spaceXxl = 32.dp
}
