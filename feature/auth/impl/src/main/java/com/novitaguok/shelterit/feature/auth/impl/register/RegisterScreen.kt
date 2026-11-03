package com.novitaguok.shelterit.feature.auth.impl.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItSpacing.spaceXl
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItTheme
import com.novitaguok.shelterit.feature.auth.impl.R
import com.novitaguok.shelterit.feature.auth.impl.register.model.RegisterUiEvent
import com.novitaguok.shelterit.feature.auth.impl.register.model.RegisterUiState

@Composable
fun RegisterScreen(
    state: RegisterUiState,
    onEvent: (RegisterUiEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = ShelterItTheme.colors.background)
            .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 28.dp),
    ) {
        RegisterHeader()
        RegisterForm()
        RegisterFooter()
    }
}

@Composable
fun RegisterHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.feature_auth_impl_title),
            color = ShelterItTheme.colors.onSurface,
            style = ShelterItTheme.typography.displaySmall,
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(R.string.feature_auth_impl_desc),
            color = ShelterItTheme.colors.onSurfaceVariant,
            style = ShelterItTheme.typography.bodySmall,
        )
    }
}

@Composable
fun RegisterForm(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {

    }
}

@Composable
fun RegisterFooter(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(spaceXl),
        horizontalArrangement = Arrangement.Center,
    ) {
        val annotatedString = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = ShelterItTheme.colors.onSurfaceVariant
                ),
            ) {
                append("Already have an account? ")
            }
            withStyle(
                style = SpanStyle(
                    color = ShelterItTheme.colors.primary
                )
            ) {
                append("Sign in")
            }
        }

        Text(
            text = annotatedString,
            style = ShelterItTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(name = "Register — light", showBackground = true)
@Composable
private fun RegisterScreenLightPreview() {
    ShelterItTheme(darkTheme = false) {
        RegisterScreen(
            state = RegisterUiState(),
            onEvent = { },
        )
    }
}

@Preview(name = "Register — dark", showBackground = true)
@Composable
private fun RegisterScreenDarkPreview() {
    ShelterItTheme(darkTheme = true) {
        RegisterScreen(
            state = RegisterUiState(),
            onEvent = { },
        )
    }
}
