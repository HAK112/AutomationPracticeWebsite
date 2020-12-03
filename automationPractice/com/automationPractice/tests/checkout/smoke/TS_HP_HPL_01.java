package com.automationPractice.tests.checkout.smoke;

import org.openqa.selenium.WebDriver;

import com.automationPractice.tests.TestClass;

public class TS_HP_HPL_01 extends TestClass {

	public TS_HP_HPL_01(WebDriver driver,String baseURL,String expectedResult) {
		super(driver,baseURL,expectedResult);
	}

	@Override
	public void test() {
		System.out.println("\n=============================================================================================================");
		System.out.println("Test Case ID: TS_HP_HPL_01");
		System.out.println("Test Case Summary: Verify that Home Page Exists\n");
		System.out.println("Detailed Steps: \n");
		navigateToWebsite();
		System.out.println("Comparing Page Title");
		if(!verifyResultContains(driver.getTitle(), getExpectedResult())){
			System.out.println("Title Case Failed. Actual Result and Expected Result Differs");
			return;
		}
		System.out.println("Test Passes\n");
	}
	
}
