package com.novitaguok.shelterit.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItTheme

@Composable
fun ShelterItFilledButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    isEnabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = isEnabled,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = ShelterItTheme.colors.primary,
            contentColor = ShelterItTheme.colors.onPrimary,
        ),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 13.dp),
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(8.dp))
        }
        Text(
            text = text,
            style = ShelterItTheme.typography.bodyMedium
        )
    }
}

@Composable
fun ShelterItTonalButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    isEnabled: Boolean = true,
) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        enabled = isEnabled,
        shape = CircleShape,
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = ShelterItTheme.colors.secondaryContainer,
            contentColor = ShelterItTheme.colors.onSecondaryContainer,
        ),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 13.dp),
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(8.dp))
        }
        Text(text, style = ShelterItTheme.typography.bodyMedium)
    }
}

@Composable
fun ShelterItOutlinedButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    isEnabled: Boolean = true,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = isEnabled,
        shape = CircleShape,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = ShelterItTheme.colors.primary,
        ),
        border = BorderStroke(1.dp, ShelterItTheme.colors.outline),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 13.dp),
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
            Spacer(Modifier.width(8.dp))
        }
        Text(text, style = ShelterItTheme.typography.bodyMedium)
    }
}

@Preview(name = "Filled button — light", showBackground = true)
@Composable
fun ShelterItFilledButtonLightPreview() {
    ShelterItTheme(darkTheme = false) {
        Surface {
            ShelterItFilledButton(
                onClick = {},
                text = "Adopt",
            )
        }
    }
}

@Preview(name = "Filled button — dark", showBackground = true)
@Composable
fun ShelterItFilledButtonDarkPreview() {
    ShelterItTheme(darkTheme = true) {
        Surface {
            ShelterItFilledButton(
                onClick = {},
                text = "Adopt",
            )
        }
    }
}

@Preview(name = "Tonal button — light", showBackground = true)
@Composable
fun ShelterItTonalButtonLightPreview() {
    ShelterItTheme(darkTheme = false) {
        Surface {
            ShelterItTonalButton(
                onClick = {},
                text = "Adopt",
            )
        }
    }
}

@Preview(name = "Tonal button — dark", showBackground = true)
@Composable
fun ShelterItTonalButtonDarkPreview() {
    ShelterItTheme(darkTheme = true) {
        Surface {
            ShelterItTonalButton(
                onClick = {},
                text = "Adopt",
            )
        }
    }
}

@Preview(name = "Outlined button — light", showBackground = true)
@Composable
fun ShelterItOutlinedButtonLightPreview() {
    ShelterItTheme(darkTheme = false) {
        Surface {
            ShelterItOutlinedButton(
                onClick = {},
                text = "Adopt",
            )
        }
    }
}

@Preview(name = "Outlined button — dark", showBackground = true)
@Composable
fun ShelterItOutlinedButtonDarkPreview() {
    ShelterItTheme(darkTheme = true) {
        Surface {
            ShelterItOutlinedButton(
                onClick = {},
                text = "Adopt",
            )
        }
    }
}

