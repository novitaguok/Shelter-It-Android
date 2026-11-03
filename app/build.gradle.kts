import com.novitaguok.shelterit.ShelterItBuildType

plugins {
    alias(libs.plugins.shelterit.android.application)
    alias(libs.plugins.shelterit.android.application.compose)
    alias(libs.plugins.shelterit.android.application.flavors)
    alias(libs.plugins.shelterit.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    defaultConfig {
        applicationId = "com.novitaguok.shelterit"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes { // TODO(check NiA)
        debug {
            applicationIdSuffix = ShelterItBuildType.DEBUG.applicationIdSuffix
        }
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }

    packaging {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions.unitTests.isIncludeAndroidResources = true

    namespace = "com.novitaguok.shelterit"
}

dependencies {
    implementation(projects.feature.auth.api)
    implementation(projects.feature.auth.impl)
    implementation(projects.feature.onboarding.api)
    implementation(projects.feature.onboarding.impl)

//    implementation(projects.core.common)
//    implementation(projects.core.ui)
    implementation(projects.core.designsystem)
//    implementation(projects.core.data)
//    implementation(projects.core.model)
//    implementation(projects.core.analytics)
//    implementation(projects.core.notifications)

//    implementation(libs.androidx.navigation3.ui)
    implementation(libs.androidx.compose.material3.adaptive)
    implementation(libs.androidx.compose.material3.adaptive.layout)
    implementation(libs.androidx.compose.material3.adaptive.navigation)
    implementation(libs.androidx.compose.material3.adaptive.navigation3)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.lifecycle.runtimeCompose)
//    implementation(libs.androidx.lifecycle.viewModel.navigation3)
//    implementation(libs.androidx.window.core)
//    implementation(libs.coil.kt)
    implementation(libs.kotlinx.serialization.json)

    ksp(libs.hilt.compiler)

//    androidTestImplementation(projects.core.testing)
//    androidTestImplementation(libs.androidx.compose.ui.test)
    androidTestImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.kotlin.test)
}
