plugins {
    alias(libs.plugins.shelterit.android.library)
    alias(libs.plugins.shelterit.android.library.compose)
}

android {
    namespace = "com.novitaguok.shelterit.designsystem"
    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    api(libs.androidx.compose.ui.text.google.fonts)
    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)
    api(libs.androidx.compose.material.iconsExtended)
    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.material3.adaptive)
    api(libs.androidx.compose.material3.navigationSuite)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.util)

    implementation(libs.coil.kt.compose)

    testImplementation(libs.androidx.compose.ui.test.junit4)

    testImplementation(libs.hilt.android.testing)
}