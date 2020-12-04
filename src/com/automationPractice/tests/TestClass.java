package com.automationPractice.tests;

import java.io.IOException;
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
	
	protected ExcelFileHandling excelFileHandler;
	protected static String excelFileLocation,testCaseID,moduleName;
	String baseURL, testClassVerificationString;
	HashMap<String, String> testData;

	public abstract void test() throws IOException;
	
	public TestClass(WebDriver driver, String baseURL) throws IOException {
		this.driver = driver;
		checkoutPage = new CheckoutPage(this.driver);
		homePage = new HomePage(this.driver);
		summerDressesPage = new SummerDressesPage(this.driver);
		this.baseURL = baseURL;
		test();
	}
	
	public void setExpectedResult(String expectedResult) {
		testClassVerificationString = expectedResult;
	}
	
	private void setTestDataLocation(String excelFileLocation) {
		TestClass.excelFileLocation = excelFileLocation;
	}
	
	private void setTestCaseName(String testCaseID) {
		TestClass.testCaseID = testCaseID;
	}
	
	private void setSheetName(String moduleName) {
		TestClass.moduleName = moduleName;
	}
	
	//Use this function in the test method
	public void getExcelFileData(String excelFileLocation,String moduleName, String testCaseName) throws IOException {
		setTestDataLocation(excelFileLocation);
		setSheetName(moduleName);
		setTestCaseName(testCaseName);
		excelFileHandler = new ExcelFileHandling(TestClass.excelFileLocation, TestClass.moduleName, TestClass.testCaseID);
		testData = excelFileHandler.readTestData();
	}
	
	public void writeData(String data) throws IOException {
		excelFileHandler.writeTestResult(data);
	}
	
	public void getTestData() {
		testData = excelFileHandler.readTestData();
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
    
    public String getExpectedResultFromHasmap(String data) {
    	return testData.get(data);
    }
    
    
}
