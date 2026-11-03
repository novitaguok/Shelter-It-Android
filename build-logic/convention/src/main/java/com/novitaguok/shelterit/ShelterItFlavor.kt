package com.novitaguok.shelterit

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ProductFlavor
import org.gradle.kotlin.dsl.invoke

@Suppress("EnumEntryName")
enum class FlavorDimension {
    contentType,
}

@Suppress("EnumEntryName")
enum class ShelterItFlavor(val dimension: FlavorDimension, val applicationIdSuffix: String? = null) {
    demo(FlavorDimension.contentType, applicationIdSuffix = "demo"),
    prod(FlavorDimension.contentType)
}

fun configureFlavors(
    commonExtension: CommonExtension,
    flavorConfigurationBlock: ProductFlavor.(flavor: ShelterItFlavor) -> Unit = {}
) {
    commonExtension.apply {
        FlavorDimension.entries.forEach { flavorDimension ->
            flavorDimensions += flavorDimension.name
        }

        productFlavors {
            ShelterItFlavor.entries.forEach { csFlavor ->
                register(csFlavor.name) {
                    dimension = csFlavor.dimension.name
                    flavorConfigurationBlock(this, csFlavor)
                    if (commonExtension is ApplicationExtension && this is ApplicationProductFlavor) {
                        if (csFlavor.applicationIdSuffix != null) {
                            applicationIdSuffix = csFlavor.applicationIdSuffix
                        }
                    }
                }
            }
        }
    }
}
