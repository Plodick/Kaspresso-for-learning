package com.kaspersky.tutorial.screen

import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.tutorial.R
import com.kaspersky.kaspresso.tutorial.user.LoadUserActivity
import io.github.kakaocup.kakao.progress.KProgressBar
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object LoadUserScreen : KScreen<LoadUserScreen>() {

    override val layoutId: Int = R.layout.activity_load_user
    override val viewClass: Class<*> = LoadUserActivity::class.java

    val loadingButton = KButton { withId(R.id.loading_button) }
    val progressBarLoading = KProgressBar { withId(R.id.progress_bar_loading) }
    val username = KTextView { withId(R.id.username) }
    val error = KTextView { withId(R.id.error) }
}
