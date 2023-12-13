plugins {
    id("convention.android-app")
    id("org.jetbrains.kotlin.android")
}

android {
    defaultConfig {
        minSdk = 21

        applicationId = "com.kaspersky.kaspresso.tutorial"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        testInstrumentationRunnerArguments["clearPackageData"] = "true"
    }
    packagingOptions {
        resources {
            excludes += setOf("META-INF/LICENSE.md", "META-INF/LICENSE-notice.md")
        }
    }

    testOptions {
        execution = "ANDROIDX_TEST_ORCHESTRATOR"
    }
    namespace = "com.kaspersky.kaspresso.tutorial"
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.7.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.core:core-ktx:+")
    androidTestImplementation("androidx.test.ext:junit-ktx:1.1.4")
    // Для тестов
    androidTestImplementation("com.kaspersky.android-components:kaspresso:1.5.3")
    androidTestImplementation("io.mockk:mockk-android:1.13.3")
    androidTestUtil("androidx.test:orchestrator:1.4.2")
    debugImplementation("androidx.fragment:fragment-testing-manifest:1.6.0"){
        isTransitive = false
    }
    androidTestImplementation("androidx.fragment:fragment-testing:1.6.0")
}
