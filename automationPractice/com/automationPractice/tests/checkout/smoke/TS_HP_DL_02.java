package com.automationPractice.tests.checkout.smoke;

import org.openqa.selenium.WebDriver;

import com.automationPractice.tests.TestClass;

public class TS_HP_DL_02 extends TestClass {

	public TS_HP_DL_02(WebDriver driver, String baseURL,String expectedResult) {
		super(driver, baseURL,expectedResult);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("\n=============================================================================================================");
		System.out.println("Test Case ID: TS_HP_DL_02");
		System.out.println("Verify that after clicking on \"Summer Dresses\" link in the navigation bar under \"Dresses\" Heading  goes to the respective page\n");
		System.out.println("Detailed Steps: \n");	
		navigateToWebsite();
		System.out.println("Checking for Dress Element");
		if(verifyResultContains(homePage.getDressesNavBarText(), "DRESSES")) {
			System.out.println("Dress Element Found\n");
			System.out.println("Checking for Summer Dress Element");
			if(!verifyResultContains(homePage.getSummerDressesSubMenuText(), "SUMMER DRESSES")) {
				System.out.println("Title Case Failed. Actual Result and Expected Result Differs");
				return;
			}
			
		}
		homePage.clickSummerDresses();
		if(!verifyResultContains(driver.getTitle(), getExpectedResult())) {
			System.out.println("Title Case Failed. Actual Result and Expected Result Differs");
			return;
		}
		System.out.println("Test Case Passes\n");
	}

}
