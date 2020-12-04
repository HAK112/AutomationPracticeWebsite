package com.automationPractice.tests.homepage.smoke;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.automationPractice.tests.TestClass;

public class TS_HP_01_01 extends TestClass {

	public TS_HP_01_01(WebDriver driver,String baseURL) throws IOException {
		super(driver,baseURL);
	}

	@Override
	public void test() throws IOException {
		getExcelFileData("resource//testData//testData.xlsx", "Dashboard", "TS_HP_01_01");
		setExpectedResult(getExpectedResultFromHasmap("ExpectedResult"));
		System.out.println("\n=============================================================================================================");
		System.out.println("Test Case ID: "+TestClass.testCaseID);
		System.out.println("Test Case Summary: Verify that Home Page Exists\n");
		System.out.println("Detailed Steps: \n");
		navigateToWebsite();
		System.out.println("Comparing Page Title");
		if(!verifyResultEquals(driver.getTitle(), getExpectedResult())){
			System.out.println("Title Case Failed. Actual Result and Expected Result Differs");
			writeData("FAIL");
			return;
		}
		writeData("Pass");
		System.out.println("Test Passes\n");
	}
	
}
