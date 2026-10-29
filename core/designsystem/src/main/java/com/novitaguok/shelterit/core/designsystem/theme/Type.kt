package com.novitaguok.shelterit.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.novitaguok.shelterit.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val plusJakartaSansName = GoogleFont("Plus Jakarta Sans")
val PlusJakartaSans = FontFamily(
    Font(googleFont = plusJakartaSansName, fontProvider = provider, weight = FontWeight.Normal),
    Font(googleFont = plusJakartaSansName, fontProvider = provider, weight = FontWeight.SemiBold),
    Font(googleFont = plusJakartaSansName, fontProvider = provider, weight = FontWeight.Bold)
)

val interName = GoogleFont("Inter")
val Inter = FontFamily(
    Font(googleFont = interName, fontProvider = provider, weight = FontWeight.Normal),
    Font(googleFont = interName, fontProvider = provider, weight = FontWeight.Medium),
    Font(googleFont = interName, fontProvider = provider, weight = FontWeight.SemiBold)
)

// Type roles from the design system. Roles the DS does not define
// (displayMedium, headlineSmall, titleSmall, bodySmall, ...) alias the
// nearest defined role so nothing falls back to the baseline font.
internal val ShelterItTypography = Typography(
    displayLarge = TextStyle(fontFamily = PlusJakartaSans, fontWeight = FontWeight.Bold, fontSize = 40.sp), // Display
    displayMedium = TextStyle(fontFamily = PlusJakartaSans, fontWeight = FontWeight.Bold, fontSize = 32.sp),
    displaySmall = TextStyle(fontFamily = PlusJakartaSans, fontWeight = FontWeight.Bold, fontSize = 28.sp),
    headlineMedium = TextStyle(fontFamily = PlusJakartaSans, fontWeight = FontWeight.Bold, fontSize = 28.sp), // Headline
    headlineLarge = TextStyle(fontFamily = PlusJakartaSans, fontWeight = FontWeight.Bold, fontSize = 28.sp),
    headlineSmall = TextStyle(fontFamily = PlusJakartaSans, fontWeight = FontWeight.Bold, fontSize = 28.sp),
    titleLarge = TextStyle(fontFamily = PlusJakartaSans, fontWeight = FontWeight.SemiBold, fontSize = 22.sp), // Title L
    titleMedium = TextStyle(fontFamily = PlusJakartaSans, fontWeight = FontWeight.SemiBold, fontSize = 16.sp), // Title M
    titleSmall = TextStyle(fontFamily = PlusJakartaSans, fontWeight = FontWeight.SemiBold, fontSize = 16.sp),
    bodyLarge = TextStyle(fontFamily = Inter, fontWeight = FontWeight.Normal, fontSize = 16.sp), // Body L
    bodyMedium = TextStyle(fontFamily = Inter, fontWeight = FontWeight.Normal, fontSize = 14.sp), // Body M
    bodySmall = TextStyle(fontFamily = Inter, fontWeight = FontWeight.Normal, fontSize = 14.sp),
    labelLarge = TextStyle(fontFamily = Inter, fontWeight = FontWeight.SemiBold, fontSize = 14.sp), // Label L
    labelMedium = TextStyle(fontFamily = Inter, fontWeight = FontWeight.Medium, fontSize = 12.sp), // Label M
    labelSmall = TextStyle(fontFamily = Inter, fontWeight = FontWeight.Medium, fontSize = 12.sp),
)
