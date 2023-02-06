package org_nebra_tests

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.MediaEntityBuilder
import com.aventstack.extentreports.Status
import com.aventstack.extentreports.markuputils.ExtentColor
import com.aventstack.extentreports.markuputils.MarkupHelper
import com.aventstack.extentreports.reporter.ExtentSparkReporter
import com.aventstack.extentreports.reporter.configuration.Theme
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.testng.ITestContext
import org.testng.ITestResult
import org.testng.annotations.*
import org.testng.xml.XmlTest
import org_nebra_driver.Driver
import org_nebra_driver.DriverManager
import org_nebra_listeners.ListenerClass
import org_nebra_reports.ExtentLogger
import org_nebra_reports.ExtentManager
import org_nebra_reports.ExtentReport
import org_nebra_utils.ScreenshotsUtils
import java.awt.Desktop
import java.io.File
import java.lang.reflect.Method
import java.util.*


open class TestBase {

    var extent: ExtentReports? = null
    var suite: ExtentTest? = null
    var test: ExtentTest? = null
    var clazz: ExtentTest? = null
    var method: ExtentTest? = null

    @BeforeSuite
    fun suiteset(context: ITestContext){
        ExtentReport.initReports()
    }


    @AfterSuite
    fun setAfterSuite(){
        ExtentReport.flushReports()
    }

    @BeforeTest
    fun testset(context: ITestContext){

        //test = ExtentReport.createTest(context.currentXmlTest.name)?.assignAuthor("Branko Milovanovic")?.assignCategory("Chrome")?.assignDevice("PC")
    }

    @BeforeClass
    fun report(context: ITestContext){
        Driver.initDriver("chrome")
        val className = javaClass.name
        val name = className.substringAfterLast(".")
        clazz = ExtentReport.createTest(name)?.assignAuthor("Branko Milovanovic")?.assignCategory("Chrome")?.assignDevice("PC")

    }

    @AfterClass
    fun afterclass(){
        Driver.quitDriver()
    }

    @BeforeMethod
    fun setUp(result: ITestResult, m: Method) {
        method = clazz?.createNode(m.name)
    }

    @AfterMethod
    fun tearDown(testResult: ITestResult, testMethod: Method){
        //Driver.quitDriver()

        when (testResult.status) {
            ITestResult.FAILURE -> {
                method?.log(Status.FAIL, MarkupHelper.createLabel(testResult.name + "Test Case failed due to below issues", ExtentColor.RED))
                method?.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(Driver.getBase64Image()).build())
                method?.fail(testResult.throwable.toString())
                method?.fail(Arrays.toString(testResult.throwable.stackTrace))
            }
            ITestResult.SUCCESS -> {
                method?.log(Status.PASS, MarkupHelper.createLabel(testResult.name + "Test Case Passed", ExtentColor.GREEN))
            }
            else -> {
                method?.log(Status.SKIP, MarkupHelper.createLabel(testResult.name + "Test Case skipped", ExtentColor.YELLOW))
            }
        }
    }
}