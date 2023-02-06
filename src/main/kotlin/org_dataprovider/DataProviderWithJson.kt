package org_dataprovider

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import java.io.File
import java.io.IOException

class DataProviderWithJson {

    @Test(dataProvider = "dataProvideWithJson")
    fun testDPWithJson(map: Map<String, Any>) {
        map.forEach { (k: String, v: Any) -> println("$k:$v") }
    }

    @DataProvider
    @Throws(IOException::class, JsonMappingException::class, IOException::class)
    fun dataProvideWithJson(): Array<Any>? {
        val map1: HashMap<String, Any> =
        jacksonObjectMapper().readValue(File(System.getProperty("user.dir") + "\\src\\test\\resources\\jsons\\config.json"), object : TypeReference<HashMap<String, Any>>() {})

        val map2: HashMap<String, Any> =
            jacksonObjectMapper().readValue(File(System.getProperty("user.dir") + "\\src\\test\\resources\\jsons\\config.json"), object : TypeReference<HashMap<String, Any>>() {})


        return arrayOf(map1, map2)
    }
}