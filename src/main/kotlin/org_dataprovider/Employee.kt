package org_dataprovider

import org.testng.annotations.DataProvider

open class Employee(name: String?, id: String?) {

    private val name: String? = name
    private val id: String? = id

    fun getName(): String? {
        return name
    }

    fun getId(): String? {
        return id
    }

    companion object {
        @JvmStatic
        @DataProvider
        fun getEmployee(): Array<Employee>? {
            return arrayOf(
                Employee("branko", "1234"),
                Employee("testing", "2345")
            )
        }
    }
}