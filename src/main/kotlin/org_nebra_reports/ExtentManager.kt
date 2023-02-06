package org_nebra_reports

import com.aventstack.extentreports.ExtentTest

object ExtentManager {
    private val extTest = ThreadLocal<ExtentTest>()

    fun getExtentTest(): ExtentTest? {
        return extTest.get()
    }

    fun setExtentTest(test: ExtentTest) {
        extTest.set(test)
    }

    fun unload() {
        extTest.remove()
    }
}