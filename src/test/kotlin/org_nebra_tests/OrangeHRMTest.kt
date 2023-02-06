package org_nebra_tests

import org.assertj.core.api.Assertions
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import org.testng.annotations.DataProvider
import org.testng.annotations.Ignore
import org.testng.annotations.Test
import org_nebra_driver.DriverManager
import org_nebra_driver.DriverManager.getDriver
import org_nebra_enums.WaitStrategy
import org_nebra_listeners.RetryFailedTests
import org_nebra_pages.OrangeHRMLoginPage
import org_nebra_utils.DataProviderUtils
import java.util.concurrent.TimeUnit

class OrangeHRMTest: TestBase() {

    @Test(priority = 1)
    fun orange1(){
        DriverManager.getDriver()?.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        val title = OrangeHRMLoginPage.enterUserName("Admin12", WaitStrategy.CLICKABLE).enterPassword("admin123", WaitStrategy.CLICKABLE)
            .clickLogin(WaitStrategy.CLICKABLE).
            clickUserName().clickLogout().getTitle()

        println(title)
        Assertions.assertThat(title)
            .isEqualTo("OrangeHRM")
    }

    @Test(priority = 2)
    fun orange2(){
        DriverManager.getDriver()?.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
        val title = OrangeHRMLoginPage.enterUserName("Admin12", WaitStrategy.CLICKABLE).enterPassword("admin123", WaitStrategy.CLICKABLE)
            .clickLogin(WaitStrategy.CLICKABLE).
            clickUserName().clickLogout().getTitle()

        println(title)
        Assertions.assertThat(title)
            .isEqualTo("OrangeHRM")
    }

    @Test(priority = 3)
    fun orange3(){
        DriverManager.getDriver()?.findElement(By.xpath("ssas"))
    }
    @Ignore
    @Test(priority = 3)
    fun orange4(){

    }

    @Test(priority = 3)
    fun orange5(){

    }

    @Ignore
    @Test(dataProvider = "getName")
    fun loginLogout(username: String, password: String) {
        getDriver()!!.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

        val title = OrangeHRMLoginPage.enterUserName("username", WaitStrategy.CLICKABLE).enterPassword("password", WaitStrategy.CLICKABLE)
            .clickLogin(WaitStrategy.CLICKABLE).
            clickUserName().clickLogout().getTitle()

        println(title)
        Assertions.assertThat(title)
            .isEqualTo("OrangeHRM")
    }
    @Ignore
    @Test
    fun newTest(data: Map<String, String>) {
        getDriver()!!.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)

        val title = OrangeHRMLoginPage.enterUserName(data["username"], WaitStrategy.CLICKABLE).enterPassword(data["password"], WaitStrategy.CLICKABLE)
            .clickLogin(WaitStrategy.CLICKABLE).
            clickUserName().clickLogout().getTitle()

        println(title)
        Assertions.assertThat(title)
            .isEqualTo("OrangeHRM")
    }

    @DataProvider
    fun getName(): Array<Array<Any>> {
        return arrayOf(
            arrayOf("Admin", "admin123"),
            /**arrayOf("admin123", "admin123"),
            arrayOf("Admin123", "admin123")*/
        )
    }
}