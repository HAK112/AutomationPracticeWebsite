package com.automationPractice.tests.homepage.smoke;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.automationPractice.tests.TestClass;

public class TS_HP_02_01 extends TestClass {
	
	public TS_HP_02_01(WebDriver driver, String baseURL) throws IOException {
		super(driver, baseURL);
	}

	@Override
	public void test() throws IOException {
		// TODO Auto-generated method stub
		getExcelFileData("resource//testData//testData.xlsx", "Dashboard", "TS_HP_02_01");
		setExpectedResult(getExpectedResultFromHasmap("ExpectedResult"));
		System.out.println("\n=============================================================================================================");
		System.out.println("Test Case ID: "+TestClass.testCaseID);
		System.out.println("Test Case Summary: Verify that after hovering on the navigation bar's \"Women\" heading shows the sub-menu:\r\n"
				+ "Casual Dresses\r\n"
				+ "Winter Dresses\r\n"
				+ "Summer Dresses\n");
		System.out.println("Detailed Steps: \n");
		navigateToWebsite();
		System.out.println("Checking for Dress Element");
		if(verifyResultContains(homePage.getDressesNavBarText(), "DRESSES")) {
			System.out.println("Dress Element Found\n");
			System.out.println("Checking for Summer Dress Element");
			if(!verifyResultContains(homePage.getSummerDressesSubMenuText(), getExpectedResult())) {
				System.out.println("Title Case Failed. Actual Result and Expected Result Differs");
				writeData("Fail");
				return;
			}
		}
		writeData("Pass:d1");
		System.out.println("Test Case Passes\n");
	}

}
