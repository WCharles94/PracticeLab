package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import page.BaseClass;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	
	public File src;
	public ExcelDataProvider() {

		 src = new File(System.getProperty("user.dir") + "/TestData/Application_data.xlsx");

		try {
			
			FileInputStream fis = new FileInputStream(src);
			
			 
			
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {

			System.out.println("Excel Failed to load " + e.getMessage());
		}

	}

	public String getStringData(String sheetName, int row, int column) {
		String data = wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public int getNumericData(String sheetName, int row, int column) {
		int data = (int) wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		return data;
	}

	public int getNumberOfRows(String sheetName) {
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();
	}

	public int getNumberOfColums(String sheetName, int row) {
			
		return wb.getSheet(sheetName).getRow(row).getPhysicalNumberOfCells();

	}
	
	public void setDatatoExcel(String SheetName, int row, String Status, int column) {
		
		wb.getSheet(SheetName).getRow(row).createCell(column).setCellValue(Status);
		
	}
	
	public void writeExcel() {
		
		try {
			wb.write(BaseClass.fout);
			wb.close();
		} catch (IOException e) {
			
			System.out.println("enable to write data in excel");
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	
	

}
