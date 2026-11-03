plugins {
    alias(libs.plugins.shelterit.android.feature.impl)
    alias(libs.plugins.shelterit.android.library.compose)
}

android {
    namespace = "com.novitaguok.shelterit.feature.onboarding.impl"
    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    //    implementation(projects.core.domain)
//    implementation(projects.core.notifications)
    implementation(projects.feature.onboarding.api)
    implementation(libs.androidx.activity.compose)

    testImplementation(libs.hilt.android.testing)

//    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
}
