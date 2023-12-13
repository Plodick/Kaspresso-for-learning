package com.kaspersky.tutorial.tests

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.tutorial.MainActivity
import com.kaspersky.kaspresso.tutorial.R
import com.kaspersky.tutorial.screen.MainScreen
import com.kaspersky.tutorial.screen.SimpleActivityScreen
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import org.junit.Rule
import org.junit.Test

class SimpleActivityTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    /**
     * Example of simplification
     */
    val BaseAssertions.isVisible
        get() = this.isVisible()

    @Test
    fun simpleTest() {
        MainScreen {
            simpleActivityButton {
                isVisible
                isClickable()
                containsText("Simple test")
                click()
            }
        }
        SimpleActivityScreen {
            simpleTitle.isVisible()
            changeTitleButton.isClickable()
            simpleTitle.hasText(R.string.simple_activity_default_title)
            inputText.replaceText("new title")
            changeTitleButton.click()
            simpleTitle.hasText("new title")
        }
    }
}
