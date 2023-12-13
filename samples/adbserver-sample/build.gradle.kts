plugins {
    id("convention.android-app")
    id("org.jetbrains.kotlin.android")
}

android {
    defaultConfig {
        applicationId = "com.kaspersky.adbserver.sample"
    }
    namespace = "com.kaspersky.adbserver.sample"
}

dependencies {
    implementation(libs.kotlinStdlib)
    implementation(libs.appcompat)
    implementation(projects.adbServer.adbServerDevice)
    implementation(libs.multidex)
    implementation("androidx.core:core-ktx:+")
}
