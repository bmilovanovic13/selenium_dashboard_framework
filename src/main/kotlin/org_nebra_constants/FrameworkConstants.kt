package org_nebra_constants

import org_nebra_enums.ConfigProperties
import org_nebra_utils.PropertyUtils

object FrameworkConstants {

    private  val RESOURCES_PATH = System.getProperty("user.dir") + "\\src\\test\\resources"
    private  val CHROME_DRIVER_PATH = System.getProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe")
    private  val FIREFOX_DRIVER_PATH = System.getProperty("webdriver.chrome.driver", "$RESOURCES_PATH\\executables\\geckodriver.exe")
    private  val CONFIG_FILE_PATH = "$RESOURCES_PATH\\config\\config_properties"
    private val JSON_CONFIG_FILE_PATH = "$RESOURCES_PATH\\config\\config.json"
    private val EXCEL_PATH = System.getProperty("user.dir") + "\\excel\\book1.xlsx"
    private val EXTENT_REPORT_FOLDER_PATH =  System.getProperty("user.dir") + "\\extent-test-output"
    private val RUN_MANAGER_SHEET = "RUNMANAGER"
    private val DATA_SHEET = "DATA"
    private var extentReportFilePath = ""
    private  val EXPLICITWAIT: Long= 10

    fun getExplicitWait(): Long{
        return EXPLICITWAIT
    }

    fun getConfigFilePath(): String{
        return CONFIG_FILE_PATH
    }

    fun getChromeDriverPath(): String{
        return CHROME_DRIVER_PATH
    }

    fun getFirefoxDriverPath(): String {
        return FIREFOX_DRIVER_PATH
    }

    fun getExcelPath(): String{
        return EXCEL_PATH
    }

    fun getJsonConfigFilePath(): String{
        return JSON_CONFIG_FILE_PATH
    }

    fun getExtentReportFilePath(): String{
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath()
        }
        return extentReportFilePath
    }

    fun getRunManagerSheet(): String{
        return RUN_MANAGER_SHEET
    }

    fun getDataSheet(): String{
        return DATA_SHEET
    }
    private fun createReportPath(): String {
        return if (PropertyUtils.getValue(ConfigProperties.OVERRIDE_REPORTS).equals("no", ignoreCase = true)){
            EXTENT_REPORT_FOLDER_PATH+System.currentTimeMillis()+"\\index.html"
        } else {
            "$EXTENT_REPORT_FOLDER_PATH\\index.html"
        }
    }
}