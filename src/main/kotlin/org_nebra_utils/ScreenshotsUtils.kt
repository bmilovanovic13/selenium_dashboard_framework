package org_nebra_utils

import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org_nebra_driver.DriverManager

object ScreenshotsUtils {

    fun getBase64Image(): String?{
        return (DriverManager.getDriver() as TakesScreenshot?)!!.getScreenshotAs(OutputType.BASE64)
    }
}