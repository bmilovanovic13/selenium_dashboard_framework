package org_nebra_tests

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.testng.Assert
import org.testng.annotations.Ignore
import org.testng.annotations.Test
import org_nebra_driver.DriverManager
import org_nebra_driver.DriverManager.getDriver
import org_nebra_enums.WaitStrategy
import org_nebra_factories.ExplicitWaitFactory
import org_nebra_pages.OrangeHRMLoginPage
import java.util.concurrent.TimeUnit

class HomePageTest: TestBase() {
    @Ignore
    @Test
    fun test2() {
        DriverManager.getDriver()?.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        val title = OrangeHRMLoginPage.enterUserName("Admin", WaitStrategy.CLICKABLE).enterPassword("admin123", WaitStrategy.CLICKABLE)
            .clickLogin(WaitStrategy.CLICKABLE).
            clickUserName().clickLogout().getTitle()

        println(title)
        Assertions.assertThat(title)
            .isEqualTo("OrangeHRM")
    }

    @Test(priority = 3)
    fun orange89(){

    }

    @Test(priority = 3)
    fun orange90(){

    }


}