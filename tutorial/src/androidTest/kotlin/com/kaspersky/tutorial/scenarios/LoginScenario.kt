package com.kaspersky.tutorial.scenarios

import com.kaspersky.kaspresso.testcases.api.scenario.Scenario
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import com.kaspersky.kaspresso.tutorial.R
import com.kaspersky.tutorial.screen.LoginScreen
import com.kaspersky.tutorial.screen.MainScreen

class LoginScenario(
    private val username: String,
    private val password: String
) : Scenario() {

    override val steps: TestContext<Unit>.() -> Unit = {
        step("Open login screen") {
            //device.screenshots.take("before_open_login_screen")
            MainScreen {
                loginActivityButton {
                    isVisible()
                    isClickable()
                    click()
                }
            }
           // device.screenshots.take("after_open_login_screen")
        }
        step("Check elements visibility") {
            device.screenshots.take("check_elements_visibility")
            LoginScreen {
                inputUsername {
                    isVisible()
                    hasHint(R.string.login_activity_hint_username)
                }
                inputPassword {
                    isVisible()
                    hasHint(R.string.login_activity_hint_password)
                }
                loginButton {
                    isVisible()
                    isClickable()
                }
            }
        }
        step("Try to login") {
            LoginScreen {
                inputUsername {
                    replaceText(username)
                }
                inputPassword {
                    replaceText(password)
                }
                loginButton {
                    click()
                }
            }
        }
    }
}
