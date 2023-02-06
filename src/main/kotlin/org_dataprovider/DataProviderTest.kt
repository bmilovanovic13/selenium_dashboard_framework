package org_dataprovider

import org.testng.Assert
import org.testng.annotations.DataProvider
import org.testng.annotations.Ignore
import org.testng.annotations.Test
import java.lang.reflect.Method

class DataProviderTest {
    @Ignore
    @Test(dataProvider = "getEmployee", dataProviderClass = Employee::class)
    fun test1(emp: Employee) {
        println(emp.getName())
        println(emp.getId())
        println("entering username")
        println("entering password")
        println("entering login")
        Assert.assertTrue(false)
    }

    @Test(dataProvider = "getData1")
    fun test2(username: String) {
        println(username)
        println("entering username")
        println("entering password")
        println("entering login")
        Assert.assertTrue(false)
    }

    @Test(dataProvider ="getData1")
    fun test3(emp: Employee){
        println(emp.getName())
    }

    @DataProvider
    fun getData(): Array<String>? {
        return arrayOf("branko", "milovanovic", "testing")
    }

    @DataProvider
    fun getData1(m: Method): Array<Any>? {

        if (m.name.equals("test3", ignoreCase = true)){
            return arrayOf(
                Employee("branko", "1234"),
                Employee("testing", "2345")
            )
        }
        else if (m.name.equals("test2", ignoreCase = true)) {
            return arrayOf("branko", "milovanovic", "testing")
        }
        return null
    }
}