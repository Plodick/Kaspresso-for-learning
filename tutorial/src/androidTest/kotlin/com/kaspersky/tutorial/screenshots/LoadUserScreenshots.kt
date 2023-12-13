package com.kaspersky.tutorial.screenshots

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.DocLocScreenshotTestCase
import com.kaspersky.kaspresso.tutorial.R
import com.kaspersky.kaspresso.tutorial.user.LoadUserActivity
import com.kaspersky.kaspresso.tutorial.user.LoadUserFragment
import com.kaspersky.kaspresso.tutorial.user.LoadUserViewModel
import com.kaspersky.kaspresso.tutorial.user.State
import com.kaspersky.kaspresso.tutorial.user.User
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Rule
import org.junit.Test

class LoadUserScreenshots : DocLocScreenshotTestCase(locales = "en, fr") {

    @get:Rule
    val activityRule = activityScenarioRule<LoadUserActivity>()

    val _state = MutableStateFlow<State>(State.Initial)

    val viewModel = mockk<LoadUserViewModel>(relaxed = true) {
        every { state } returns _state
    }

    @Test
    fun takeScreenshots() {
        launchFragmentInContainer(
            themeResId = R.style.Theme_Kaspresso
        ) {
            LoadUserFragment.newTestInstance(mockedViewModel = viewModel)
        }
        _state.value = State.Initial
        captureScreenshot("Initial state")
        _state.value = State.Progress
        captureScreenshot("Progress state")
        _state.value = State.Content(user = User(name = "Test", lastName = "Test"))
        captureScreenshot("Content state")
        _state.value = State.Error
        captureScreenshot("Error state")
    }
}
