package org_nebra_listeners

import com.aventstack.extentreports.ExtentReports
import org.testng.*
import org_nebra_reports.ExtentLogger
import org_nebra_reports.ExtentReport
import java.lang.reflect.Method
import java.util.*

class ListenerClass: ITestListener, ISuiteListener {


    override fun onStart(suite: ISuite?) {
        ExtentReport.initReports()

    }

    override fun onFinish(suite: ISuite?) {

        ExtentReport.flushReports()
    }

    override fun onTestStart(result: ITestResult) {
        //This is in before class
        //ExtentReport.createTest(result.method.methodName)

    }

    override fun onTestSuccess(result: ITestResult?) {
        ExtentLogger.pass(result?.method?.methodName)
        //reports.createTest(javaClass.name).createNode(result?.method?.methodName)
    }

    override fun onTestFailure(result: ITestResult) {
        //ExtentLogger.failed(result.method.methodName + " is failed ", true, ExtentTest = )
        //ExtentLogger.fail(result.throwable.toString())
        //ExtentLogger.fail(Arrays.toString(result.throwable.stackTrace))
    }

    override fun onTestSkipped(result: ITestResult) {
        ExtentLogger.skip(result.method.methodName + "is skipped")
    }
}