package com.automationPractice.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileHandling {
	String fileLocation;
	FileInputStream fileInputStream;
	FileOutputStream fileOutputStream;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
	String testCaseName;
	HashMap<String, String> testData;
	int requiredRow;
	int requiredColumn;
	
	//Constructor
	public ExcelFileHandling(String fileLocation,String sheetName,String testCaseName) throws IOException {
		this.fileLocation = fileLocation;
		fileInputStream = new FileInputStream(fileLocation);
		workBook = new XSSFWorkbook(fileInputStream);
	
		sheet = workBook.getSheet(sheetName);
		testData = new HashMap<>();
		this.testCaseName = testCaseName;
	}
	
	//This method allows you to get the row of the testCase that you require
	public int getRequiredRow() {
		int rowNumber = 0;
		for(int i=0;i<=sheet.getLastRowNum();i++) {
			//System.out.println(testCaseName+sheet.getRow(i).getCell(0).toString());
			if(testCaseName.equals(sheet.getRow(i).getCell(0).toString())) {
				rowNumber = i;
				break;
			}
		}
		return rowNumber;
	}
	
	//This method allows you to get the column(TestResult) of the testCase that you require
	public void getRequiredColumn() {
		requiredColumn = sheet.getRow(0).getCell(sheet.getRow(0).getLastCellNum()-1).getColumnIndex();
	}
	
	//This method gets all the data from a specific row and dumps it into the hashmap
	public HashMap<String, String> readTestData() {
		requiredRow = getRequiredRow();
		if(requiredRow!=0) {
			for(int i = 0 ; i < sheet.getRow(requiredRow).getLastCellNum(); i++) {
				if(sheet.getRow(requiredRow).getCell(i)==null)
					sheet.getRow(requiredRow).createCell(i).setCellType(CellType.STRING);
				testData.put(sheet.getRow(0).getCell(i).toString(),sheet.getRow(requiredRow).getCell(i).toString());
			}
		}
		return testData;
	}
	
	//To write Data
	@SuppressWarnings("deprecation")
	public void writeTestResult(String data) throws IOException {
		if(requiredRow==0) {
			System.out.println("required row is zero");
			return;}
		getRequiredColumn();
		Row row = sheet.getRow(getRequiredRow());
		int cellIndex = row.getLastCellNum();
		Cell cell = row.getCell(requiredColumn);
		if(cell == null)
			cell = row.createCell(cellIndex);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(data);
		fileOutputStream = new FileOutputStream(fileLocation);
		workBook.write(fileOutputStream);
		fileOutputStream.close();
		//System.out.println("Data Written: " +data);
	}
	
	public HashMap<String, String> getTestData(){
		return testData;
	}
	
	public String getExpectedValue(String key) {
		return testData.get("ExpectedResult");
	}
	
	public void closeFile() throws IOException {
		fileInputStream.close();
		workBook.close();
	}
}