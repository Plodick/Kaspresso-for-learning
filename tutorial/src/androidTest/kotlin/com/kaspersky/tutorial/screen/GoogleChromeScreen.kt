package com.kaspersky.tutorial.screen

import com.kaspersky.components.kautomator.component.edit.UiEditText
import com.kaspersky.components.kautomator.screen.UiScreen

object GoogleChromeScreen : UiScreen<GoogleChromeScreen>() {

    override val packageName: String = "com.android.chrome"

    val searchEditText = UiEditText { withText("Search or type web address") }
}
