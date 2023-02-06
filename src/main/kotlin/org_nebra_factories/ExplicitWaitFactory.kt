package org_nebra_factories

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import org_nebra_constants.FrameworkConstants
import org_nebra_driver.DriverManager
import org_nebra_enums.WaitStrategy

object ExplicitWaitFactory {

    fun performExplicitWait(waitStrategy: WaitStrategy, by: By): WebElement? {
        var element: WebElement? = null

        when (waitStrategy) {
            WaitStrategy.CLICKABLE -> {
                element = WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait()).until(
                    ExpectedConditions.elementToBeClickable(by))
            }
            WaitStrategy.PRESENCE -> {
                element = WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait()).until(
                    ExpectedConditions.presenceOfElementLocated(by))
            }
            WaitStrategy.VISIBLE -> {
                element = WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitWait()).until(
                    ExpectedConditions.visibilityOfElementLocated(by))
            }
            WaitStrategy.NONE -> {
                org_nebra_driver.DriverManager.getDriver()?.findElement(by)
            }
        }
        return element
    }
}