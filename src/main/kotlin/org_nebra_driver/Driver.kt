package org_nebra_driver

import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org_nebra_constants.FrameworkConstants
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.session.FirefoxFilter
import org_nebra_enums.ConfigProperties
import org_nebra_utils.PropertyUtils
import java.util.*

object Driver {

    @Throws(Exception::class)
    fun initDriver(browser: String) {
        if (Objects.isNull(DriverManager.getDriver())) {
            if (browser.equals("chrome", ignoreCase = true)) {
                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath())

                DriverManager.setDriver(ChromeDriver())
            } else if (browser.equals("firefox", ignoreCase = true)) {
                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getFirefoxDriverPath())

                DriverManager.setDriver(FirefoxDriver())
            }
            DriverManager.getDriver()?.get(PropertyUtils.getValue(ConfigProperties.URL))
        }
    }

    fun getBase64Image(): String?{
        return (DriverManager.getDriver() as TakesScreenshot?)!!.getScreenshotAs(OutputType.BASE64)
    }
    fun quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver()?.quit()
            DriverManager.unload()
        }
    }
}