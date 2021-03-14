import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.4.31"
    kotlin("native.cocoapods")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

version = "1.0"

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }
    ios()

    cocoapods {
        summary = "CocoaPods test library"
        homepage = "https://github.com/JetBrains/kotlin"
        ios.deploymentTarget = "14"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.SqlDelight.runtime)
                implementation(Dependencies.Ktor.clientCore)
                implementation(Dependencies.Ktor.clientCio)
                implementation(Dependencies.Ktor.clientSerialization)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(Dependencies.SqlDelight.androidDriver)
                implementation(Dependencies.Android.material)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(Dependencies.SqlDelight.nativeDriver)
                implementation(Dependencies.Ktor.clientIos)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(Dependencies.AndroidTest.junit)
            }
        }

        val iosTest by getting
    }

    targets.filterIsInstance<KotlinNativeTarget>().forEach{
        it.binaries.filterIsInstance<org.jetbrains.kotlin.gradle.plugin.mpp.Framework>()
            .forEach { lib ->
                lib.isStatic = false
                lib.linkerOpts.add("-lsqlite3")
            }
    }
}

sqldelight {
    database("KmmAppDatabase") { // This will be the name of the generated database class.
        packageName = "shared.persistence"
    }
}

android {
    compileSdkVersion(30)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(30)
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework =
        kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)
