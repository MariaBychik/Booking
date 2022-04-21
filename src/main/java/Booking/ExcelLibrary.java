package Booking;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelLibrary {

    HSSFWorkbook workbook;
    HSSFSheet sheet;

    public ExcelLibrary() throws IOException {
        String excelPath = "src/test/resources/excel.xls";
        File file = new File(excelPath);
        FileInputStream fis = new FileInputStream(file);
        workbook = new HSSFWorkbook(fis);
    }

    public String readData(String sheetName, int row, int col){
        sheet=workbook.getSheet("Sheet1");
        String data = sheet.getRow(row).getCell(col).getStringCellValue();
        return data;
    }
}
