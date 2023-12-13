package com.kaspersky.tutorial.tests

import android.content.res.Configuration
import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.tutorial.MainActivity
import com.kaspersky.kaspresso.tutorial.R
import com.kaspersky.tutorial.screen.MainScreen
import com.kaspersky.tutorial.screen.WifiScreen
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WifiSampleWithStepsTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Before
    fun before() {
        device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
        device.network.toggleWiFi(true)
    }

    @After
    fun after() {
        device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
        device.network.toggleWiFi(true)
    }

    @Test
    fun wifiTest() = run {
        step("Open target screen") {
            MainScreen {
                wifiActivityButton {
                    isVisible()
                    isClickable()
                    click()
                }
            }
        }
        step("Check correct wifi status") {
            WifiScreen {
                checkWifiButton.isVisible()
                checkWifiButton.isClickable()
                wifiStatus.hasEmptyText()
                checkWifiButton.click()
                wifiStatus.hasText(R.string.enabled_status)
                device.network.toggleWiFi(false)
                checkWifiButton.click()
                wifiStatus.hasText(R.string.disabled_status)
            }
        }
        step("Rotate device and check wifi status") {
            WifiScreen {
                device.exploit.rotate()
                Assert.assertTrue(device.context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
                wifiStatus.hasText(R.string.disabled_status)
            }
        }
    }
}
