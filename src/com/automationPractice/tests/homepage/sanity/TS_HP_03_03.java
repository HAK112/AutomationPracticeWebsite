package com.automationPractice.tests.homepage.sanity;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.automationPractice.tests.TestClass;

public class TS_HP_03_03 extends TestClass {

	public TS_HP_03_03(WebDriver driver, String baseURL) throws IOException {
		super(driver, baseURL);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void test() throws IOException {
		// TODO Auto-generated method stub
		getExcelFileData("resource//testData//testData.xlsx", "Dashboard", "TS_HP_03_03");
		setExpectedResult(getExpectedResultFromHasmap("ExpectedResult"));
		System.out.println("\n=============================================================================================================");
		System.out.println("Test Case ID: "+TestClass.testCaseID);
		System.out.println("Test Case Summary: Verify that after hovering on the navigation bar's \"Women\" heading shows the sub-menu:\r\n"
				+ "Tops\r\n"
				+ "Dresses \r\n"
				+ "And whether the Dressess has Summer Dress Option");
		System.out.println("Detailed Steps: \n");	
		navigateToWebsite();
		System.out.println("Checking for Dress Element");
		if(verifyResultContains(homePage.getDressesNavBarText(), "DRESSES")) {
			System.out.println("Dress Element Found\n");
			System.out.println("Checking for Summer Dress Element");
			if(!verifyResultContains(homePage.getSummerDressesSubMenuText(), "SUMMER DRESSES")) {
				System.out.println("Title Case Failed. Actual Result and Expected Result Differs");
				writeData("Fail");
				return;
			}
		}
		System.out.println("Summer Dress Element Found\n");
		homePage.clickSummerDresses();
		if(!verifyResultEquals(driver.getTitle(), getExpectedResult())) {
			System.out.println("Title Case Failed. Actual Result and Expected Result Differs");
			writeData("Fail");
			return;
		}
		writeData("Pass");
		System.out.println("Test Case Passes\n");
	}

}
