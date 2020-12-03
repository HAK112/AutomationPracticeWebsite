package com.automationPractice.tests;

import org.openqa.selenium.WebDriver;

import com.automationPractice.pages.CheckoutPage;
import com.automationPractice.pages.HomePage;
import com.automationPractice.pages.SummerDressesPage;

public abstract class TestClass {
	protected WebDriver driver;
	
	protected CheckoutPage checkoutPage;
	protected HomePage homePage;
	protected SummerDressesPage summerDressesPage;
	
	String baseURL;
	String testClassVerificationString;
		
	public TestClass(WebDriver driver, String baseURL, String expectedString) {
		this.driver = driver;
		checkoutPage = new CheckoutPage(this.driver);
		homePage = new HomePage(this.driver);
		summerDressesPage = new SummerDressesPage(this.driver);	
		this.baseURL = baseURL;
		setExpectedResult(expectedString);
		test();
	}
	
	public abstract void test();
	
	public void setExpectedResult(String expectedResult) {
		testClassVerificationString = expectedResult;
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
    
    public void navigateToWebsite() {
    	driver.get(baseURL);
    	System.out.println("Navigating to: " + baseURL);
    }
    
}
