package com.kaspersky.tutorial.screen

import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.tutorial.MainActivity
import com.kaspersky.kaspresso.tutorial.R
import com.kaspersky.kaspresso.tutorial.permission.MakeCallActivity
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton

object MakeCallActivityScreen : KScreen<MakeCallActivityScreen>() {

    override val layoutId: Int = R.layout.activity_make_call
    override val viewClass: Class<*> = MakeCallActivity::class.java

    val inputNumber = KEditText { withId(R.id.input_number) }
    val makeCallButton = KButton { withId(R.id.make_call_btn) }
}
