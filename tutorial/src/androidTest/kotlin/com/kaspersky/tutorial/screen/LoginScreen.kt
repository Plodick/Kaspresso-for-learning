package com.kaspersky.tutorial.screen

import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.tutorial.R
import com.kaspersky.kaspresso.tutorial.login.LoginActivity
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton

object LoginScreen : KScreen<LoginScreen>() {

    override val layoutId: Int = R.layout.activity_login
    override val viewClass: Class<*> = LoginActivity::class.java

    val inputUsername = KEditText { withId(R.id.input_username) }
    val inputPassword = KEditText { withId(R.id.input_password) }
    val loginButton = KButton { withId(R.id.login_btn) }
}
