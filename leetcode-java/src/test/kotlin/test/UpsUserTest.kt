package test
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import kotlin.streams.toList

fun main() {
    val workbook = XSSFWorkbook("/Users/yuankui/Downloads/ups.xlsx")
    val sheet = workbook.getSheetAt(0)!!
    
    sheet.map { 
        listOf(it.getCell(7), it.getCell(9), it.getCell(18)).map {
            it.toString() 
        }
    }.flatMap {
                val (status, appkey, content) = it
        content.split("\n")
                .stream()
                .skip(1)
                .map { 
                    listOf(status, appkey, it)
                }
                .toList()
    }.filter {
        val (status) = it
        status == "1.0"
    }.filter {
        val (_, _, resource) = it
        resource.contains("子资源")
    }.map { 
        val (status, appkey, resource) = it
        listOf(appkey, resource)
    }.forEach { 
        println(it)
    }
}