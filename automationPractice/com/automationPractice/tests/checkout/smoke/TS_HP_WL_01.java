package com.automationPractice.tests.checkout.smoke;

import org.openqa.selenium.WebDriver;

import com.automationPractice.tests.TestClass;

public class TS_HP_WL_01 extends TestClass {

	public TS_HP_WL_01(WebDriver driver, String baseURL,String expectedResult) {
		super(driver, baseURL,expectedResult);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("\n=============================================================================================================");
		System.out.println("Test Case ID: TS_HP_WL_01");
		System.out.println("Test Case Summary: Verify that after hovering on the navigation bar's \"Women\" heading shows the sub-menu:\r\n"
				+ "Tops\r\n"
				+ "Dresses\n");
		System.out.println("Detailed Steps: \n");	
		navigateToWebsite();
		System.out.println("Checking for Dress Element");
		if(verifyResultContains(homePage.getDressesNavBarText(), "DRESSES")) {
			System.out.println("Dress Element Found\n");
			System.out.println("Checking for Summer Dress Element");
			if(!verifyResultContains(homePage.getSummerDressesSubMenuText(), getExpectedResult())) {
				System.out.println("Title Case Failed. Actual Result and Expected Result Differs");
				return;
			}
		}
		System.out.println("Test Case Passes\n");
	}

}
