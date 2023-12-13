package com.kaspersky.tutorial.screen

import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.tutorial.R
import com.kaspersky.kaspresso.tutorial.wifi.WiFiActivity
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView

object WifiScreen : KScreen<WifiScreen>() {

    override val layoutId: Int = R.layout.activity_wifi
    override val viewClass: Class<*> = WiFiActivity::class.java

    val checkWifiButton = KButton { withId(R.id.check_wifi_btn) }
    val wifiStatus = KTextView { withId(R.id.wifi_status) }
}
