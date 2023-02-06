package org_nebra_reports

import com.aventstack.extentreports.MediaEntityBuilder
import org_nebra_enums.ConfigProperties
import org_nebra_reports.ExtentManager.getExtentTest
import org_nebra_utils.PropertyUtils
import org_nebra_utils.ScreenshotsUtils


object ExtentLogger {

    fun pass(message: String?) {
        getExtentTest()!!.pass(message)
    }

    fun fail(message: String?) {
        getExtentTest()!!.fail(message)
    }

    fun skip(message: String?) {
        getExtentTest()!!.skip(message)
    }

    fun passed(message: String, isScreenShotNeeded: Boolean){
        if(PropertyUtils.getValue(ConfigProperties.PASSED_STEPS_SCREENSHOTS).equals("yes") && isScreenShotNeeded) {
            getExtentTest()?.pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64Image()).build())
        }
        else {
            pass(message)
        }
    }

    fun failed(message: String, isScreenShotNeeded: Boolean){
        if(PropertyUtils.getValue(ConfigProperties.FAILED_STEPS_SCREENSHOTS).equals("yes") && isScreenShotNeeded) {
            getExtentTest()?.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64Image()).build())
        }
        else {
            fail(message)
        }
    }

    fun skipped(message: String, isScreenShotNeeded: Boolean){
        if(PropertyUtils.getValue(ConfigProperties.SKIPPPED_STEPS_SCREENSHOTS).equals("yes") && isScreenShotNeeded) {
            getExtentTest()?.skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotsUtils.getBase64Image()).build())
        }
        else {
            skip(message)
        }
    }
}