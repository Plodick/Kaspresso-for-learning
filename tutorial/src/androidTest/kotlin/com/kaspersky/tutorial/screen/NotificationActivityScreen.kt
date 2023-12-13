package com.kaspersky.tutorial.screen

import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.tutorial.R
import com.kaspersky.kaspresso.tutorial.notification.NotificationActivity
import io.github.kakaocup.kakao.text.KButton

object NotificationActivityScreen : KScreen<NotificationActivityScreen>() {

    override val layoutId: Int = R.layout.activity_notification
    override val viewClass: Class<*> = NotificationActivity::class.java

    val showNotificationButton = KButton { withId(R.id.show_notification_button) }
}
