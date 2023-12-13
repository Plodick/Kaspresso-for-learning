plugins {
    id("convention.android-app")
    id("org.jetbrains.kotlin.android")
}

android {
    defaultConfig {
        applicationId = "com.kaspersky.kaspresso.kautomatorsample"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["clearPackageData"] = "true"
    }

    testOptions {
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
    }
    namespace = "com.kaspersky.kaspresso.kautomatorsample"
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraint)
    implementation(libs.multidex)
    implementation("androidx.core:core-ktx:+")

    androidTestImplementation(projects.kaspresso)
    androidTestImplementation(libs.androidXTestExtJunitKtx)
    androidTestImplementation(libs.androidXTestExtJunit)

    androidTestUtil(libs.androidXTestOrchestrator)
}
