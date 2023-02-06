package org_nebra_utils

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org_nebra_constants.FrameworkConstants
import java.io.FileInputStream


object ExcelUtils {

    fun getTestDetails(sheetName: String): MutableList<Map<String, String>> {
        val fs = FileInputStream(FrameworkConstants.getExcelPath())
        val wb = XSSFWorkbook(fs)

        val sheet = wb.getSheet(sheetName)

        val lastRowNumber = sheet.lastRowNum
        val lastColumnNumber = sheet.getRow(0).lastCellNum

        var map: Map<String, String>
        val list: MutableList<Map<String, String>> = ArrayList()

        for (i in 0..lastRowNumber) {
            map = HashMap()
            for (j in 0 until lastColumnNumber) {
                val key = sheet.getRow(0).getCell(j).stringCellValue
                val value = sheet.getRow(i).getCell(j).stringCellValue
                map[key] = value
            }
            list.add(map)
        }
        fs.close()
        return list
    }
}