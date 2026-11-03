package com.novitaguok.shelterit.feature.auth.impl.register.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItSpacing.spaceXs
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItSpacing.spaceXxs
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItTheme
import com.novitaguok.shelterit.core.designsystem.theme.success
import com.novitaguok.shelterit.feature.auth.impl.register.model.PasswordStrength
import com.novitaguok.shelterit.feature.auth.impl.register.model.StrengthTone

@Composable
fun PasswordStrengthIndicator(
    strength: PasswordStrength,
    modifier: Modifier = Modifier
) {
    val scheme = ShelterItTheme.colors
    val toneColor = when (strength.tone) {
        StrengthTone.Neutral -> scheme.onSurfaceVariant
        StrengthTone.Success -> scheme.success
        StrengthTone.Error -> scheme.error
    }

    Column {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(3) { idx ->
                val isFilled = idx < strength.filledBars
                val animatedColor by animateColorAsState(
                    targetValue = if (isFilled) toneColor else scheme.outlineVariant,
                    animationSpec = tween(durationMillis = 200),
                    label = "StrengthBarAnimation"
                )

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(spaceXs)
                        .clip(CircleShape)
                        .background(animatedColor)
                )
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = spaceXxs),
            text = strength.label,
            color = toneColor,
            style = ShelterItTheme.typography.labelSmall,
            textAlign = TextAlign.End
        )
    }
}

@Preview(name = "Password weak indicator — light", showBackground = true)
@Composable
fun PasswordStrengthIndicatorWeakLightPreview() {
    ShelterItTheme(darkTheme = false) {
        PasswordStrengthIndicator(strength = PasswordStrength.WEAK)
    }
}

@Preview(name = "Password weak indicator — dark", showBackground = true)
@Composable
fun PasswordStrengthIndicatorWeakDarkPreview() {
    ShelterItTheme(darkTheme = true) {
        PasswordStrengthIndicator(strength = PasswordStrength.WEAK)
    }
}

@Preview(name = "Password good indicator — light", showBackground = true)
@Composable
fun PasswordStrengthIndicatorGoodLightPreview() {
    ShelterItTheme(darkTheme = false) {
        PasswordStrengthIndicator(strength = PasswordStrength.GOOD)
    }
}

@Preview(name = "Password good indicator — dark", showBackground = true)
@Composable
fun PasswordStrengthIndicatorGoodDarkPreview() {
    ShelterItTheme(darkTheme = true) {
        PasswordStrengthIndicator(strength = PasswordStrength.GOOD)
    }
}

@Preview(name = "Password strong indicator — light", showBackground = true)
@Composable
fun PasswordStrengthIndicatorStrongLightPreview() {
    ShelterItTheme(darkTheme = false) {
        PasswordStrengthIndicator(strength = PasswordStrength.STRONG)
    }
}

@Preview(name = "Password strong indicator — dark", showBackground = true)
@Composable
fun PasswordStrengthIndicatorStrongDarkPreview() {
    ShelterItTheme(darkTheme = true) {
        PasswordStrengthIndicator(strength = PasswordStrength.STRONG)
    }
}


