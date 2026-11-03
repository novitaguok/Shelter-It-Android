plugins {
    alias(libs.plugins.shelterit.android.library)
    alias(libs.plugins.shelterit.android.library.compose)
}

android {
    namespace = "com.novitaguok.shelterit.core.ui"
}

dependencies {
    api(projects.core.designsystem)
//    api(projects.core.model)

    implementation(libs.coil.kt.compose)
}
