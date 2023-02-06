package org_nebra_utils

import org.testng.annotations.DataProvider
import org_nebra_constants.FrameworkConstants
import java.lang.reflect.Method

object DataProviderUtils {

    var list: MutableList<Map<String, String>> = ArrayList()
    @JvmStatic
    @DataProvider
    fun getData(m: Method): Array<Any> {
        val testName = m.name

        if (list.isEmpty()) {
            list = ExcelUtils.getTestDetails(FrameworkConstants.getDataSheet())
        }

        val iterationList: MutableList<Map<Any, Any>> = ArrayList()
        for(i in 0 until list.size) {
            if (list[i]["testname"].equals(testName, ignoreCase = true) && list[i]["execute"].equals("yes", ignoreCase = true)){
                    iterationList.add(list[i].toMap())
                }
            }
        return iterationList.toTypedArray()
    }
}