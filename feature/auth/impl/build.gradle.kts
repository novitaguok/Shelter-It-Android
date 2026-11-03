plugins {
    alias(libs.plugins.shelterit.android.feature.impl)
    alias(libs.plugins.shelterit.android.library.compose)
}

android {
    namespace = "com.novitaguok.shelterit.feature.auth.impl"
    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    implementation(projects.feature.auth.api)
    implementation(libs.androidx.activity.compose)

    testImplementation(libs.hilt.android.testing)
}
