package org_extantReports

import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.reporter.ExtentSparkReporter
import com.aventstack.extentreports.reporter.configuration.Theme
import org.testng.annotations.Test
import java.awt.Desktop
import java.io.File
import java.io.IOException

class ExtentReportsDemo {

    @Test
    @Throws(IOException::class)
    fun test1() {
        // Setup code
        val extent = ExtentReports()
        val spark = ExtentSparkReporter("index.html")
        extent.attachReporter(spark)
        spark.config().theme = Theme.STANDARD
        spark.config().documentTitle = "P2S Test Report"
        spark.config().reportName = "Training"

        // create test
        val test = extent.createTest("First Test")
        test.pass("Checking the logs")
        val test1 = extent.createTest("Second Test")
        test1.fail("Checking the logs in second test")

        // tear down code
        extent.flush()
        Desktop.getDesktop().browse(File("index.html").toURI())
    }
}