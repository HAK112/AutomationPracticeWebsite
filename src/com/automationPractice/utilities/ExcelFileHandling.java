package com.automationPractice.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileHandling {
	String fileLocation;
	FileInputStream fileInputStream;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
	String testCaseName;
	HashMap<String, String> testData;
	
	public ExcelFileHandling(String fileLocation,String sheetName,String testCaseName) throws IOException {
		this.fileLocation = fileLocation;
		fileInputStream = new FileInputStream(fileLocation);
		workBook = new XSSFWorkbook(fileInputStream);
		sheet = workBook.getSheet(sheetName);
		testData = new HashMap<>();
		this.testCaseName = testCaseName;
	}
	
	public int getTestRows() {
		int rowNumber = 0;
		for(int i=0;i<sheet.getLastRowNum();i++) {
			if(testCaseName.equals(sheet.getRow(i).getCell(0).toString())) {
				rowNumber = i;
				break;
			}
		}
		return rowNumber;
	}
	
	public void readTestData() {
		int row = getTestRows();
		if(row!=0) {
			for(int i = 0 ; i < sheet.getRow(row).getLastCellNum(); i++) {
				testData.put(sheet.getRow(0).getCell(i).toString(),sheet.getRow(row).getCell(i).toString());
			}
		}
	}
	
	public HashMap<String, String> getTestData(){
		return testData;
	}
}
