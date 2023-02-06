package org_nebra_listeners

import org.testng.IRetryAnalyzer
import org.testng.ITestResult
import org_nebra_enums.ConfigProperties
import org_nebra_utils.PropertyUtils

open class RetryFailedTests: IRetryAnalyzer {

    private var count = 0
    private val maxTry = 2

    override fun retry(iTestResult: ITestResult): Boolean {
        if (PropertyUtils.getValue(ConfigProperties.RETRY_FAILED_TESTS).equals("yes", ignoreCase = true)) {
            if (!iTestResult.isSuccess) {                      //Check if test not succeed
                if (count < maxTry) {                            //Check if maxtry count is reached
                    count++ //Increase the maxTry count by 1
                    iTestResult.status = ITestResult.FAILURE //Mark test as failed
                    return true //Tells TestNG to re-run the test
                } else {
                    iTestResult.status = ITestResult.FAILURE //If maxCount reached,test marked as failed
             }
            } else {
                iTestResult.status = ITestResult.SUCCESS //If test passes, TestNG marks it as passed
            }
        }
        return false
    }
}