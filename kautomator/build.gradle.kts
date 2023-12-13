plugins {
    id("convention.android-library")
    id("convention.publication-android-lib")
    id("convention.third-party-report")
    id("convention.legal-documents")
    id("org.jetbrains.kotlin.android")
}

publish {
    artifactId.set("kautomator")
}

dependencies {
    implementation(libs.kotlinStdlib)
    implementation(libs.truth)
    implementation(libs.androidXTestCore)
    implementation(libs.uiAutomator)
    implementation("androidx.core:core-ktx:+")
}
android {
    namespace = "com.kaspersky.components.kautomator"
}
