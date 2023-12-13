package com.kaspersky.tutorial.tests

import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.tutorial.screen.GoogleChromeScreen
import org.junit.Test

class GoogleChromeTest : TestCase() {

    @Test
    fun testNotSignIn() = run {
        // context - test app
        // targetContext - tested app
        step("Open Google Chrome") {
            device.targetContext.apply {
                println("PACKAGE NAME: $packageName")
                val intent = packageManager.getLaunchIntentForPackage(GOOGLE_CHROME_PACKAGE)
                startActivity(intent)
            }
        }
        step("Check search input is displayed") {
            GoogleChromeScreen {
                searchEditText.isDisplayed()
            }
        }
    }

    companion object {

        private const val GOOGLE_CHROME_PACKAGE = "com.android.chrome"
    }
}
