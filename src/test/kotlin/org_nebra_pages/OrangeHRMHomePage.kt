package org_nebra_pages

import org.openqa.selenium.By
import org_nebra_enums.WaitStrategy
import org_nebra_reports.ExtentLogger
import org_nebra_reports.ExtentManager
import org_nebra_reports.ExtentReport

object OrangeHRMHomePage:BasePage() {

    private val linkUsername = By.xpath("//p[@class='oxd-userdropdown-name']")
    private val linkLogout = By.xpath("//a[normalize-space()='Logout']")

    fun clickUserName(): OrangeHRMHomePage {
        click(linkUsername, WaitStrategy.PRESENCE, "UserName")
        return this
    }

    fun clickLogout(): OrangeHRMHomePage {
        click(linkLogout, WaitStrategy.CLICKABLE, "Logout")
        return this
    }

    fun getTitle(): String? {
        return getPageTitle()
    }
}