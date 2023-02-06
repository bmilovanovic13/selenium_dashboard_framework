package org_nebra_reports

import com.aventstack.extentreports.AnalysisStrategy
import com.aventstack.extentreports.ExtentReports
import com.aventstack.extentreports.ExtentTest
import com.aventstack.extentreports.reporter.ExtentSparkReporter
import com.aventstack.extentreports.reporter.configuration.Theme
import org_nebra_constants.FrameworkConstants
import java.awt.Desktop
import java.io.File
import java.io.IOException

object ExtentReport {

    private var extent: ExtentReports? = null
    val EXTENT_REPORT_FOLDER_PATH =  System.getProperty("user.dir") + "\\extent-test-output\\index.html"
    private var extentReportFilePath = "$EXTENT_REPORT_FOLDER_PATH\\index.html"
    fun getExtentReportFilePath(): String{
        return extentReportFilePath
    }

    fun initReports() {
        extent = ExtentReports()
        val spark = ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath())
        extent!!.attachReporter(spark)
        spark.config().theme = Theme.STANDARD
        spark.config().documentTitle = "P2S Test Report"
        spark.config().reportName = "Training"
        extent!!.setAnalysisStrategy(AnalysisStrategy.SUITE)
    }

    @Throws(IOException::class)
    fun flushReports() {
        extent!!.flush()
        ExtentManager.unload()
        Desktop.getDesktop().browse(File(FrameworkConstants.getExtentReportFilePath()).toURI())
    }

    fun createTest(testcasename: String): ExtentTest? {
        val rep = extent!!.createTest(testcasename)

        return rep
    }

    fun createNode(name: String){

    }

}