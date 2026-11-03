package com.novitaguok.shelterit.core.navigation

import androidx.navigation3.runtime.NavKey

class Navigator(val state: NavigationState) {
    fun navigate(key: NavKey) {
        when (key) {
            state.top
        }
    }
}
