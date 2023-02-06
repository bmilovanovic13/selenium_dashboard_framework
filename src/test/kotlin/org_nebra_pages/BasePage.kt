package org_nebra_pages

import org.openqa.selenium.By
import org_nebra_driver.DriverManager.getDriver
import org_nebra_enums.WaitStrategy
import org_nebra_factories.ExplicitWaitFactory
import org_nebra_reports.ExtentLogger

open class BasePage {

    protected open fun click(element: By, waitstrategy: WaitStrategy, nameOfElement: String) {
        ExplicitWaitFactory.performExplicitWait(waitstrategy, element)?.click()
    }

    protected open fun sendKeys(element: By, waitstrategy: WaitStrategy, text: String?, value: String) {
        ExplicitWaitFactory.performExplicitWait(waitstrategy, element)?.sendKeys(text)
    }

    protected open fun getPageTitle(): String? {
        return getDriver()?.title
    }
}