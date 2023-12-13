plugins {
    id("convention.android-library")
    id("convention.publication-android-lib")
    id("convention.third-party-report")
    id("convention.legal-documents")
    id("org.jetbrains.kotlin.android")
}

publish {
    artifactId.set("kaspresso-allure-support")
}

dependencies {
    api(libs.bundles.allure)

    implementation(projects.kaspresso)

    implementation(libs.kotlinStdlib)
    implementation(libs.truth)
    implementation(libs.androidXTestCore)
    implementation(libs.androidXTestRunner)
    implementation(libs.uiAutomator)
    implementation(libs.androidXTestExtJunitKtx)
    implementation("androidx.core:core-ktx:+")

    testImplementation(libs.junit)

    androidTestImplementation(libs.espressoCore)
}
android {
    namespace = "com.kaspersky.components.alluresupport"
}
