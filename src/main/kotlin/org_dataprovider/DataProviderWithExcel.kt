package org_dataprovider

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.testng.annotations.DataProvider
import org.testng.annotations.Test
import java.io.FileInputStream


class DataProviderWithExcel {

    @Test(dataProvider ="getData")
    fun test1(map: Map<Any, Any>){
        println(map.get("username"))
    }

    @DataProvider
    fun getData(): Array<Any?>{
        val fs = FileInputStream(System.getProperty("user.dir") + "\\excel\\testdata.xlsx")
        val workbook = XSSFWorkbook(fs)

        val sheet = workbook.getSheet("testing")


        val rownum = sheet.lastRowNum
        println(rownum)
        val columnnum = sheet.getRow(0).lastCellNum.toInt()

        val data = arrayOfNulls<Any>(rownum)
        var map: Map<Any, Any>

        for (i in 1 until rownum + 1) {
            map = HashMap()
            for (j in 0 until columnnum) {

                val key = sheet.getRow(0).getCell(j).stringCellValue
                val value = sheet.getRow(i).getCell(j).stringCellValue
                map[key] = value
                data[i-1] = map
            }
        }
        return data
    }
}