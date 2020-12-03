package com.automationPractice.tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.automationPractice.pages.CheckoutPage;
import com.automationPractice.pages.HomePage;
import com.automationPractice.pages.SummerDressesPage;
import com.automationPractice.utilities.ExcelFileHandling;

public abstract class TestClass {
	protected WebDriver driver;
	
	protected CheckoutPage checkoutPage;
	protected HomePage homePage;
	protected SummerDressesPage summerDressesPage;
	
	ExcelFileHandling excelFileHandler;
	
	String baseURL, excelFileLocation,testCaseID,moduleName,testClassVerificationString;
	HashMap<String, String> testData;

	public abstract void test();
		
	public TestClass(WebDriver driver, String baseURL, String expectedString) {
		this.driver = driver;
		checkoutPage = new CheckoutPage(this.driver);
		homePage = new HomePage(this.driver);
		summerDressesPage = new SummerDressesPage(this.driver);
		//excelFileHandler = new ExcelFileHandling(testDataLocation, testCaseName, sheetName);
		this.baseURL = baseURL;
		setExpectedResult(expectedString);
		test();
	}
	
	private void setExpectedResult(String expectedResult) {
		testClassVerificationString = expectedResult;
	}
	
	private void setTestDataLocation(String excelFileLocation) {
		this.excelFileLocation = excelFileLocation;
	}
	
	private void setTestCaseName(String testCaseID) {
		this.testCaseID = testCaseID;
	}
	
	private void setSheetName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	public void getExcelFileData(String excelFileLocation,String moduleName, String sheetName) {
		setTestDataLocation(excelFileLocation);
		setSheetName(moduleName);
		setTestCaseName(sheetName);
	}
	
	public void navigateToWebsite() {
		driver.get(baseURL);
		System.out.println("Navigating to: " + baseURL);
	}
	
	public String getExpectedResult() {
		return testClassVerificationString;
	}
	
	//Verifier with Contians method
    public boolean verifyResultContains(String actualResult, String expectedResult) {
    	System.out.println("Actual Result: " +actualResult);
    	System.out.println("Expected Result: " +expectedResult);
    	if(!actualResult.contains(expectedResult)) {
    		return false;
    	};
    	return true;
    }
    
    //Verifier with Equals Method
    public boolean verifyResultEquals(String actualResult, String expectedResult) {
    	System.out.println("Actual Result: " +actualResult);
    	System.out.println("Expected Result: " +expectedResult);
    	if(!actualResult.equals(expectedResult)) {
    		return false;
    	};
    	return true;
    }
    
    
}
