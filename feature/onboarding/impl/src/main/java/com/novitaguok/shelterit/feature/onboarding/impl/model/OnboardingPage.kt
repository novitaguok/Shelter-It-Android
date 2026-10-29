package com.novitaguok.shelterit.feature.onboarding.impl.model

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.novitaguok.shelterit.core.designsystem.component.ShelterItIcons

data class OnboardingPage(
    val headline: String,
    val body: String,
    val ctaLabel: String,
    val secondaryLabel: String,
    val secondaryAction: SecondaryAction = SecondaryAction.SIGN_IN,
    /** null = brand logo mark instead of a photo. */
    val photoUrl: String? = null,
    val headlineSize: TextUnit = 36.sp,
    val chipIcon: ImageVector? = null,
    val chipLabel: String? = null,
)

enum class SecondaryAction {
    SIGN_IN,
    SKIP,
}

internal val DefaultOnboardingPages = listOf(
    OnboardingPage(
        headline = "Every pet deserves a home.",
        body = "Shelter It connects stray, surrendered and shelter pets with people ready to love them.",
        ctaLabel = "Get started",
        secondaryLabel = "I already have an account",
        headlineSize = 40.sp,
    ),
    OnboardingPage(
        headline = "Every listing is real.",
        body = "Photos, temperament notes and health records, published directly by verified shelters.",
        ctaLabel = "Continue",
        secondaryLabel = "Skip for now",
        photoUrl = "https://images.unsplash.com/photo-1554456854-55a089fd4cb2?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&q=80&w=800",
        chipIcon = ShelterItIcons.ShieldCheck,
        chipLabel = "Verified shelter",
    ),
    OnboardingPage(
        headline = "Apply from anywhere.",
        body = "Send an application, book a meet-and-greet, and track every reply in one place.",
        ctaLabel = "Get started",
        secondaryLabel = "I already have an account",
        photoUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSyFrau_h9wYLITJkVTYN2Gje-WRUmzXa--mxNnLAuaIA&s=10",
        chipIcon = ShelterItIcons.Clock,
        chipLabel = "3-day reply",
    ),
)
