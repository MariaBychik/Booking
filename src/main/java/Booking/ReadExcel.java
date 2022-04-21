package Booking;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    public static String readWorkbook() throws IOException {

        FileInputStream file = new FileInputStream("src/test/resources/excel.xls");
        HSSFWorkbook workBook = new HSSFWorkbook(file);
        HSSFSheet sheet = workBook.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum();
        for (int i = 0; i <= rowCount; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j <= row.getLastCellNum(); j++) {
                String data1 = sheet.getRow(i).getCell(j).getStringCellValue();
                return data1;
            }
        }
        return null;
    }
}

