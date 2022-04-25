package Booking;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class ReadExcel {
    public static Map <String,String> readExcelFile() throws IOException {
        Map<String, String> testData = new HashMap<String, String>();
        HSSFCell cell1 = null;
        HSSFCell cell2 = null;
        try {
            FileInputStream file = new FileInputStream("src/test/resources/excel.xls");
            HSSFWorkbook workBook = new HSSFWorkbook(file);
            HSSFSheet sheet = workBook.getSheet("Sheet1");
            final Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext()) {
                final HSSFRow row = (HSSFRow) rowIterator.next();
                final Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    cell1 = (HSSFCell) cellIterator.next();
                    final String key = cell1.getRichStringCellValue().toString();
                    if (key == "")
                        break;
                    cell2 = (HSSFCell) cellIterator.next();
                    final String value = cell2.getRichStringCellValue().toString();

                    testData.put(key, value);
                }
            }
        } catch (FileNotFoundException e){
        e.printStackTrace();
        }
        return testData;
    }
    }


