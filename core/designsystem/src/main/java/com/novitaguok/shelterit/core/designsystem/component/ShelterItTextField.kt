package com.novitaguok.shelterit.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItTheme

@Composable
fun ShelterItTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    supportingText: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = true
) {
    val scheme = ShelterItTheme.colors

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(ShelterItTheme.shapes.medium)
                .background(scheme.surfaceContainerHigh)
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp),
        ) {
            Text(
                text = label,
                color = scheme.onSurfaceVariant,
                style = ShelterItTheme.typography.labelSmall,
            )
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = singleLine,
                keyboardOptions = keyboardOptions,
                textStyle = ShelterItTheme.typography.bodyMedium.copy(
                    color = scheme.onSurface,
                ),
                cursorBrush = SolidColor(scheme.primary),
            )
        }
        if (supportingText != null) {
            Text(
                text = supportingText,
                color = scheme.onSurfaceVariant,
                style = ShelterItTheme.typography.bodySmall,
            )
        }
    }
}

@Preview(name = "Text Field — light", showBackground = true)
@Composable
fun ShelterItTextFieldLightPreview() {
    ShelterItTheme(darkTheme = false) {
        Surface {
            ShelterItTextField(
                value = "some text",
                onValueChange = {},
                label = "label"
            )
        }
    }
}

@Preview(name = "Text Field — dark", showBackground = true)
@Composable
fun ShelterItTextFieldDarkPreview() {
    ShelterItTheme(darkTheme = true) {
        Surface {
            ShelterItTextField(
                value = "some text",
                onValueChange = {},
                label = "label"
            )
        }
    }
}

