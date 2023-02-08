import Dependencies.applyAndroidX
import Dependencies.applyGlide
import Dependencies.applyHilt
import Dependencies.applyRetrofit2
import Dependencies.applyTest

plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")

}

android {
    namespace = "com.nanioi.cleanpracticeapp"
    compileSdk = Dependencies.COMPILE_SDK
    buildFeatures {
        dataBinding = true
    }
    defaultConfig {
        applicationId = "com.nanioi.cleanpracticeapp"
        minSdk = Dependencies.MIN_SDK
        targetSdk = Dependencies.TARGET_SDK
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(Dependencies.Google.MATERIAL)
    implementation("androidx.appcompat:appcompat:1.6.0")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    applyAndroidX()
    applyTest()
    applyRetrofit2()
    applyHilt()
    applyGlide()
}
kapt {
    correctErrorTypes = true
}
hilt {
    enableTransformForLocalTests = true
}