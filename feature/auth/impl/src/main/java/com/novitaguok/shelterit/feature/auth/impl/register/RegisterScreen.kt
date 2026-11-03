package com.novitaguok.shelterit.feature.auth.impl.register

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.outlined.PrivacyTip
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.novitaguok.shelterit.core.designsystem.component.ShelterItFilledButton
import com.novitaguok.shelterit.core.designsystem.component.ShelterItTextField
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItSpacing.spaceL
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItSpacing.spaceMd
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItSpacing.spaceSm
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItSpacing.spaceXl
import com.novitaguok.shelterit.core.designsystem.theme.ShelterItTheme
import com.novitaguok.shelterit.feature.auth.impl.R
import com.novitaguok.shelterit.feature.auth.impl.register.components.PasswordStrengthIndicator
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
            .padding(spaceXl),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(spaceL)
        ) {
            RegisterHeader()
            RegisterFormField(
                state = state,
                onEvent = onEvent,
                onNextField = { focusManager.moveFocus(FocusDirection.Down) },
                onSubmitForm = {
                    focusManager.clearFocus()
                    onEvent(RegisterUiEvent.OnSubmit)
                },
            )
            RegisterTnc(
                isAccepted = false,
                isError = false,
                onAcceptedChange = {},
                onGuidelinesClick = {},
                onPrivacyClick = {}
            )
            RegisterPrivacyTip()
            ShelterItFilledButton(
                text = "Create Account",
                icon = Icons.AutoMirrored.Filled.ArrowForward,
                onClick = { onEvent(RegisterUiEvent.OnSubmit) },
                modifier = Modifier.fillMaxWidth()
            )
        }
        RegisterFooter(
            onSignInClick = { onEvent(RegisterUiEvent.OnNavigateToSignIn) }
        )
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
fun RegisterFormField(
    state: RegisterUiState,
    onEvent: (RegisterUiEvent) -> Unit,
    onNextField: () -> Unit,
    onSubmitForm: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(spaceMd)
    ) {
        ShelterItTextField(
            value = state.name,
            onValueChange = { onEvent(RegisterUiEvent.OnNameChanged(it)) },
            label = stringResource(R.string.feature_auth_impl_full_name),
            supportingText = state.nameError,
            isError = state.nameError != null,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { onNextField() }),
            modifier = Modifier.fillMaxWidth()
        )
        ShelterItTextField(
            value = state.email,
            onValueChange = { onEvent(RegisterUiEvent.OnNameChanged(it)) },
            label = stringResource(R.string.feature_auth_impl_email),
            supportingText = state.emailError,
            isError = state.emailError != null,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(onNext = { onNextField() }),
            modifier = Modifier.fillMaxWidth()
        )
        ShelterItTextField(
            value = state.password,
            onValueChange = { onEvent(RegisterUiEvent.OnNameChanged(it)) },
            label = stringResource(R.string.feature_auth_impl_password),
            supportingText = state.passwordError,
            isError = state.passwordError != null,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Send
            ),
            keyboardActions = KeyboardActions(onDone = { onSubmitForm() }),
            visualTransformation =
                if (state.isPasswordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            trailingContent = {
                IconButton(
                    onClick = { onEvent(RegisterUiEvent.OnTogglePasswordVisibility) },
                    modifier = Modifier.size(18.dp)
                ) {
                    Icon(
                        imageVector =
                            if (state.isPasswordVisible) Icons.Outlined.VisibilityOff
                            else Icons.Outlined.Visibility,
                        tint = ShelterItTheme.colors.onSurfaceVariant,
                        contentDescription =
                            if (state.isPasswordVisible) "Hide password"
                            else "Show password",
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        )
        PasswordStrengthIndicator(state.passwordStrength)
    }
}

@Composable
fun RegisterPrivacyTip(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(14.dp),
            imageVector = Icons.Outlined.PrivacyTip,
            contentDescription = "Privacy tip"
        )
        Spacer(modifier = Modifier.width(spaceSm))
        Text(
            text = "Your details stay private. Verified shelters only.",
            style = ShelterItTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Normal
            ),
            color = ShelterItTheme.colors.onSurfaceVariant
        )
    }
}

@Composable
fun RegisterFooter(
    onSignInClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
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
            withLink(
                link = LinkAnnotation.Clickable(
                    tag = "navigate_to_sign_in",
                    styles = TextLinkStyles(
                        style = SpanStyle(
                            color = ShelterItTheme.colors.primary
                        )
                    ),
                    linkInteractionListener = { onSignInClick() }
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

@Composable
fun RegisterTnc(
    isAccepted: Boolean,
    isError: Boolean,
    onAcceptedChange: (Boolean) -> Unit,
    onGuidelinesClick: () -> Unit,
    onPrivacyClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scheme = ShelterItTheme.colors
    val linkStyle = TextLinkStyles(
        style = SpanStyle(
            color = scheme.onSurface,
            fontWeight = FontWeight.Medium,
            textDecoration = TextDecoration.Underline,
        ),
        pressedStyle = SpanStyle(
            color = scheme.primary,
            fontWeight = FontWeight.Medium,
            textDecoration = TextDecoration.Underline,
        ),
    )
    val annotatedTnc = buildAnnotatedString {
        append("I agree to the ")
        withLink(
            LinkAnnotation.Clickable(
                tag = "guidelines",
                styles = linkStyle,
                linkInteractionListener = { onGuidelinesClick() }
            )
        ) {
            append("Community Guidelines")
        }
        append(" and ")
        withLink(
            LinkAnnotation.Clickable(
                tag = "privacy",
                styles = linkStyle,
                linkInteractionListener = { onPrivacyClick() },
            ),
        ) {
            append("Privacy Policy")
        }

        append(".")
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.Top,
        ) {
            TermsCheckbox(
                checked = isAccepted,
                isError = isError,
                onCheckedChange = onAcceptedChange,
            )

            Text(
                text = annotatedTnc,
                style = ShelterItTheme.typography.bodySmall.copy(
                    color = scheme.onSurfaceVariant,
                ),
                modifier = modifier,
            )
        }

        if (isError) {
            Text(
                text = "Please accept the guidelines to continue",
                color = scheme.error,
                style = ShelterItTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 28.dp),
            )
        }
    }
}

@Composable
fun TermsCheckbox(
    checked: Boolean,
    isError: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val scheme = ShelterItTheme.colors

    Box(
        modifier = modifier
//            .minimumInteractiveComponentSize()
            .toggleable(
                value = checked,
                role = Role.Checkbox,
                onValueChange = onCheckedChange
            ),
        contentAlignment = Alignment.TopStart
    ) {
        Box(
            modifier = Modifier
                .size(18.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(if (checked) scheme.primary else Color.Transparent)
                .border(
                    width = 1.5.dp,
                    color = when {
                        isError -> scheme.error
                        checked -> scheme.primary
                        else -> scheme.outline
                    },
                    shape = RoundedCornerShape(6.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            if (checked) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    tint = scheme.onPrimary,
                    modifier = Modifier.size(12.dp)
                )
            }
        }
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
