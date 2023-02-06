package org_nebra_driver

import org.openqa.selenium.WebDriver

object DriverManager {

    private val dr = ThreadLocal<WebDriver>()

    fun getDriver(): WebDriver? {
        return dr.get()
    }

    fun setDriver(driverref: WebDriver) {
        dr.set(driverref)
    }

    fun unload() {
        dr.remove()
    }
}