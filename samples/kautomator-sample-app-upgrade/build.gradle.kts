plugins {
    id("convention.android-app")
    id("org.jetbrains.kotlin.android")
}

android {
    defaultConfig {
        applicationId = "com.kaspersky.kaspresso.sample_upgrade_tests"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    namespace = "com.kaspersky.kaspresso.upgradesample"
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.multidex)
    implementation("androidx.core:core-ktx:+")

    androidTestImplementation(projects.kaspresso)
}
