sealed class Dependencies {
    private object Versions {
        const val sqlDelight = "1.4.4"
        const val robolectric = "4.4"
        const val kotlin = "1.4.31"
        const val ktor = "1.5.2"

        object Android {
            const val material = "1.2.1"
            const val junit = "4.13.2"
        }

        object AndroidX {
            const val testExt = "1.1.2"
            const val test = "1.3.0"
        }
    }

    object SqlDelight {
        const val driver = "com.squareup.sqldelight:sqlite-driver:${Versions.sqlDelight}"
        const val nativeDriver = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"
        const val androidDriver = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
        const val iosDriver = "com.squareup.sqldelight:ios-driver:${Versions.sqlDelight}"
        const val runtime = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"
    }

    object Android {
        const val material = "com.google.android.material:material:${Versions.Android.material}"
    }

    object AndroidXTest {
        const val core = "androidx.test:core:${Versions.AndroidX.test}"
        const val junit = "androidx.test.ext:junit:${Versions.AndroidX.testExt}"
    }

    object Kotlin {
        const val testCommon = "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}"
        const val annotationTest = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
    }

    object Ktor {
        const val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        const val clientCio = "io.ktor:ktor-client-cio:${Versions.ktor}"
        const val clientIos = "io.ktor:ktor-client-ios:${Versions.ktor}"
        const val clientMock = "io.ktor:ktor-client-mock:${Versions.ktor}"
        const val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    }

    object Test {
        const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    }

    object AndroidTest {
        const val junit = "junit:junit:${Versions.Android.junit}"
    }
}
