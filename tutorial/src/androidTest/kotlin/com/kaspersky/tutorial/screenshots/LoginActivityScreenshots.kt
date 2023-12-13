package com.kaspersky.tutorial.screenshots

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.DocLocScreenshotTestCase
import com.kaspersky.kaspresso.tutorial.login.LoginActivity
import com.kaspersky.tutorial.screen.LoginScreen
import org.junit.Rule
import org.junit.Test


// Не назвал бы их тестами, а просто сбором картинок
class LoginActivityScreenshots : DocLocScreenshotTestCase(locales = "en, fr") {
    @get:Rule
    val activityRule = activityScenarioRule<LoginActivity>()

    @Test
    fun takeScreenshots() = run {
        step("Take initial state screenshots") {
            LoginScreen {
                inputUsername.isVisible()
                inputPassword.isVisible()
                loginButton.isVisible()
                captureScreenshot("Initial state")
            }
        }
    }
}
