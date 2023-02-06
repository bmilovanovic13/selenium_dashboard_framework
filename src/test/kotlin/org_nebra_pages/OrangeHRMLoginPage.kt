package org_nebra_pages

import org.openqa.selenium.By
import org_nebra_enums.WaitStrategy

object OrangeHRMLoginPage: BasePage() {


    /*
    * id
    * name
    * classname
    * linkText
    * partiallink text
    * css or xpath
    */

    /*
    * id
    * name
    * classname
    * linkText
    * partiallink text
    * css or xpath
    */
    private val textboxUsername = By.xpath("//input[@placeholder='Username']")
    private val textboxPassword = By.xpath("//input[@placeholder='Password']")
    private val buttonLogin = By.xpath("//button[@type='submit']")

    fun enterUserName(username: String?, waitstrategy: WaitStrategy): OrangeHRMLoginPage {
        sendKeys(textboxUsername, waitstrategy, username, "Username")
        return this
    }

    fun enterPassword(password: String?, waitstrategy: WaitStrategy): OrangeHRMLoginPage {
        sendKeys(textboxPassword, waitstrategy, password, "Password")
        return this
    }

    fun clickLogin(waitstrategy: WaitStrategy): OrangeHRMHomePage {
        click(buttonLogin, waitstrategy, "Login button")

        return OrangeHRMHomePage
    }

}