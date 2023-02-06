package org_nebra_utils

import org_nebra_constants.FrameworkConstants.getConfigFilePath
import org_nebra_enums.ConfigProperties
import java.io.FileInputStream
import java.util.*

object PropertyUtils {

    /**Nije mi uspelo
    private val property = Properties()
    private val CONFIGMAP: MutableMap<String, String> = HashMap()

    init {
        try {
            val file = FileInputStream(getConfigFilePath())
            property.load(file)

            for (entry: Map.Entry<Any, Any> in property.entries){
               CONFIGMAP[valueOf(entry.key.toString())] = valueOf(entry.key.toString()).trim()
            }
        } catch (FileNotFoundException: FileSystemNotFoundException) {
            FileNotFoundException.printStackTrace();
        }
        catch (IOException: IOException) {
            IOException.printStackTrace();
        }
}

    @Throws(java.lang.Exception::class)
     fun getValue(key: String): String? {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP[key])) {
            throw java.lang.Exception("Property name" + key + "is not found. Please check config_properties")
        }
        return CONFIGMAP[key]
    }
    */


    @Throws(Exception::class)
    fun getValue(key: ConfigProperties): String? {
        var value: String? = ""
        val property = Properties()
        val file = FileInputStream(getConfigFilePath())
        property.load(file)
        value = property.getProperty(key.name.lowercase())

        if (Objects.isNull(value)){
            throw Exception("Property name" + key + "is not found. Please check config_properties")
        }

        return property.getProperty(key.name.lowercase())
    }
}