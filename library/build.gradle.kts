import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
}

kotlin {
    fun KotlinNativeTarget.configure(depName: String) {
        val path = "${rootDir}/ios/GLTFKit2.xcframework/$depName"
        compilations.getByName("main") {
            val GLTFKit2 by cinterops.creating {
                defFile("src/nativeInterop/cinterop/GLTFKit.def")
                compilerOpts("-F$path")
                extraOpts += listOf("-compiler-option", "-fmodules")
            }
        }
    }
    iosX64().configure("ios-arm64_x86_64-simulator")
    iosArm64().configure("ios-arm64")
    iosSimulatorArm64().configure("ios-arm64_x86_64-simulator")

    sourceSets {
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}
