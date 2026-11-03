package com.novitaguok.shelterit.core.ui.utils

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed interface UiText {
    data class StringResource(
        @StringRes val resId: Int,
        val args: List<Any> = emptyList()
    ) : UiText

    data class DynamicString(val value: String) : UiText

    @Composable
    fun asString(): String = when (this) {
        is StringResource -> stringResource(id = resId, formatArgs = args.toTypedArray())
        is DynamicString -> value
    }
}
