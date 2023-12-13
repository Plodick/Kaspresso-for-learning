package com.kaspersky.tutorial.tests

import android.content.Context
import android.media.AudioManager
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.tutorial.MainActivity
import com.kaspersky.kaspresso.tutorial.R
import com.kaspersky.tutorial.screen.MainScreen
import com.kaspersky.tutorial.screen.MakeCallActivityScreen
import io.github.kakaocup.kakao.screen.Screen
import org.junit.Assert
import org.junit.Rule
import org.junit.Test

class MakeCallActivityRuleTest : TestCase() {

    @get:Rule
    val grantPermissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.CALL_PHONE
    )

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    private val testNumber = "11111"

    @Test
    fun justCall() {
        val number = "+79111111111"
        device.phone.emulateCall(number)
        Screen.idle(2_000L)
        device.phone.cancelCall(number)
    }

    @Test
    fun checkSuccessCall() = before {
    }.after {
        // device.phone.cancelCall(testNumber) только для входящих
        adbServer.performShell("input keyevent KEYCODE_ENDCALL")
    }.run {
        step("Open make call activity") {
            MainScreen {
                makeCallActivityButton {
                    isVisible()
                    isClickable()
                    click()
                }
            }
        }
        step("Check UI elements") {
            MakeCallActivityScreen {
                inputNumber.isVisible()
                inputNumber.hasHint(R.string.phone_number_hint)
                makeCallButton.isVisible()
                makeCallButton.isClickable()
                makeCallButton.hasText(R.string.make_call_btn)
            }
        }
        step("Try to call number") {
            MakeCallActivityScreen {
                inputNumber.replaceText(testNumber)
                makeCallButton.click()
            }
        }
        step("Check phone is calling") {
            flakySafely {
                val manager = device.context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
                Assert.assertTrue(manager.mode == AudioManager.MODE_IN_CALL)
            }
        }
    }
}
