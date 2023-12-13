plugins {
    id("convention.android-library")
    id("convention.publication-android-lib")
    id("convention.third-party-report")
    id("convention.legal-documents")
    id("org.jetbrains.kotlin.android")
}

publish {
    artifactId.set("kaspresso-compose-support")
}

dependencies {
    api(libs.kakaoCompose)
    api(libs.composeUiTest)

    implementation(projects.kaspresso)
    implementation(libs.kotlinStdlib)
    implementation("androidx.core:core-ktx:+")
}
android {
    namespace = "com.kaspersky.components.composesupport"
}
