package com.kaspersky.tutorial.tests

import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.kaspresso.interceptors.watcher.testcase.impl.screenshot.ScreenshotStepWatcherInterceptor
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.tutorial.MainActivity
import com.kaspersky.kaspresso.tutorial.afterlogin.AfterLoginActivity
import com.kaspersky.tutorial.data.TestData
import com.kaspersky.tutorial.scenarios.LoginScenario
import org.junit.Rule
import org.junit.Test

class LoginActivityGeneratedDataTest : TestCase(
   // kaspressoBuilder = Kaspresso.Builder.advanced()
    kaspressoBuilder = Kaspresso.Builder.simple().apply {
        stepWatcherInterceptors.add(ScreenshotStepWatcherInterceptor(screenshots))
    }
) {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @get:Rule
    val permissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.READ_EXTERNAL_STORAGE,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    @Test
    fun loginSuccessfulIfUsernameAndPasswordCorrect() {
        run {
            val username = TestData.username
            val password = TestData.password

           // Log.i("KASPRESSO_TEST","Generated data. Username: $username, Password: $password")
            testLogger.i("Generated data. Username: $username, Password: $password")

            step("Try to login with correct username and password") {
                scenario(
                    LoginScenario(
                        username = username,
                        password = password
                    )
                )
            }
            step("Check current screen") {
                device.activities.isCurrent(AfterLoginActivity::class.java)
            }
        }
    }
}
