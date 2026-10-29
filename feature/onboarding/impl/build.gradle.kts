plugins {
    alias(libs.plugins.shelterit.android.feature.impl)
    alias(libs.plugins.shelterit.android.library.compose)
}

android {
    namespace = "com.novitaguok.shelterit.feature.onboarding.impl"
}

dependencies {
    implementation(projects.feature.onboarding.api)

    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
}
