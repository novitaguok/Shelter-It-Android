package com.novitaguok.shelterit.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItSpacing.spaceSm
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItTheme

@Composable
fun ShelterItTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    supportingText: String? = null,
    isError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true,
    trailingContent: (@Composable () -> Unit)? = null
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
                color = if (isError) scheme.error else scheme.onSurfaceVariant,
                style = ShelterItTheme.typography.labelSmall,
            )
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(spaceSm),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    value = value,
                    onValueChange = onValueChange,
                    modifier = Modifier.weight(1f),
                    singleLine = singleLine,
                    keyboardOptions = keyboardOptions,
                    keyboardActions = keyboardActions,
                    visualTransformation = visualTransformation,
                    textStyle = ShelterItTheme.typography.bodyMedium.copy(
                        color = ShelterItTheme.colors.onSurface
                    ),
                    cursorBrush = SolidColor(scheme.primary),
                )
                if (trailingContent != null) {
                    trailingContent()
                }
            }
        }
        if (supportingText != null) {
            Text(
                text = supportingText,
                color = if (isError) scheme.error else scheme.onSurfaceVariant,
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

