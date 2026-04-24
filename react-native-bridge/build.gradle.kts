plugins {
    alias(libs.plugins.android.library)
}

val reactNativeVersion = providers.gradleProperty("reactNativeVersion").orElse("0.73.6").get()

android {
    namespace = "com.richpayment.sunmipayment.reactnative"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {
    implementation(project(":core"))
    compileOnly("com.facebook.react:react-android:$reactNativeVersion")
}

