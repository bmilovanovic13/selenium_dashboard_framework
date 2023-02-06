package org_nebra_listeners

import org.testng.IMethodInstance
import org.testng.IMethodInterceptor
import org.testng.ITestContext
import org_nebra_constants.FrameworkConstants
import org_nebra_driver.Driver
import org_nebra_utils.ExcelUtils

class MethodInterceptor:  IMethodInterceptor{
    override fun intercept(methods: MutableList<IMethodInstance>, p1: ITestContext): MutableList<IMethodInstance> {

        val list: List<Map<String, String>> = ExcelUtils.getTestDetails(FrameworkConstants.getRunManagerSheet())
        val result: MutableList<IMethodInstance> = ArrayList()

        for (i in 0 until  methods.size){
            for (j in list.indices) {
                    if (methods[i].method.methodName.equals(list[j]["testname"], ignoreCase = true) && list[j]["execute"].equals("yes", ignoreCase = true)){
                        methods[i].method.description = list[j]["testdescription"]
                        methods[i].method.invocationCount = Integer.parseInt(list[j]["count"])
                        methods[i].method.priority = Integer.parseInt(list[j]["priority"])
                        result.add(methods[i])
                    }

                }
        }
        return result
    }
}