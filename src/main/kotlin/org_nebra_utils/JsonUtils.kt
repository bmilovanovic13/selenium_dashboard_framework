package org_nebra_utils

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org_nebra_enums.ConfigProperties
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.util.*

object JsonUtils {

    private var CONFIGMAP: Map<String, String>? = null

    init {
        try {
            CONFIGMAP = jacksonObjectMapper().readValue(File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\config.json"), object : TypeReference<HashMap<String, String>>() {})
        } catch (FileNotFoundException: FileNotFoundException) {
            FileNotFoundException.printStackTrace()
        } catch (IOException: IOException) {
            IOException.printStackTrace()
        }
    }

    @Throws(Exception::class)
    operator fun get(key: ConfigProperties): String? {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP!![key.name.lowercase(Locale.getDefault())])) {
            throw Exception("Property name" + key + "is not found. Please check config_properties")
        }
        return CONFIGMAP!![key.name.lowercase(Locale.getDefault())]
    }
}