package com.automationPractice.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automationPractice.tests.homepage.smoke.TS_HP_DL_01;
import com.automationPractice.tests.homepage.smoke.TS_HP_DL_02;
import com.automationPractice.tests.homepage.smoke.TS_HP_HPL_01;
import com.automationPractice.utilities.ExcelFileHandling;

public class TestsRunner {
	
	WebDriver driver;
	String driverPath = "resource//drivers//chromedriver.exe//";
	String webSiteUrl = "http://automationpractice.com/";
	String testDataLocation = "resource//testData//testData.xlsx";
	
	public void setup(){
    	System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
	
	
	public void tearDown() {
    	driver.quit();
    }
	
	@SuppressWarnings("unused")
	public void testsHomePageSmoke() {
		TS_HP_HPL_01 testCase01 = new TS_HP_HPL_01(driver, webSiteUrl, "My Store");
		TS_HP_DL_01 testCase02 = new TS_HP_DL_01(driver, webSiteUrl, "SUMMER DRESSES");
		TS_HP_DL_02 testCase03 = new TS_HP_DL_02(driver, webSiteUrl, "Summer Dresses");
	}
	
	@SuppressWarnings("unused")
	public void testsHomePageSanity() {
		
	}
	
	@SuppressWarnings("unused")
	public void testsHomePageUI() {
		
	}
	
	@SuppressWarnings("unused")
	public void testsDressesSummerPageSmoke() {
		
	}
	
	@SuppressWarnings("unused")
	public void testsDressesSummerPageSanity() {
		
	}
	
	@SuppressWarnings("unused")
	public void testsDressesSummerPageUI() {
		
	}
	
	@SuppressWarnings("unused")
	public void testsCheckoutPageSmoke() {
		
	}
	
	@SuppressWarnings("unused")
	public void testsCheckoutPageSanity() {
		
	}
	
	@SuppressWarnings("unused")
	public void testsCheckoutPageUI() {
		
	}
	
	public static void main(String[] args) throws IOException {
//		TestsRunner runner = new TestsRunner();
// 	    runner.setup();
// 	    runner.testsHomePageSmoke();
// 	    runner.testsHomePageSanity();
// 	    runner.testsHomePageUI();
// 	    runner.testsDressesSummerPageSmoke();
//	    runner.testsDressesSummerPageSanity();
//	    runner.testsDressesSummerPageUI();
//	    runner.testsCheckoutPageSmoke();
// 	    runner.testsCheckoutPageSanity();
// 	    runner.testsCheckoutPageUI();
//	    runner.tearDown();
		ExcelFileHandling fileHandler = new ExcelFileHandling("resource\\testData\\testData.xlsx", "Dashboard","TS_HP_01_01" );
		fileHandler.readTestData();
		for ( String key : fileHandler.getTestData().keySet() ) {
		    System.out.println( key+" : "+ fileHandler.getTestData().get(key));
		}
		
	}
}
