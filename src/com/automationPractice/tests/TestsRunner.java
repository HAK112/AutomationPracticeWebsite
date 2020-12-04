package com.automationPractice.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automationPractice.tests.homepage.sanity.TS_HP_03_01;
import com.automationPractice.tests.homepage.sanity.TS_HP_03_02;
import com.automationPractice.tests.homepage.sanity.TS_HP_03_03;
import com.automationPractice.tests.homepage.smoke.TS_HP_01_01;
import com.automationPractice.tests.homepage.smoke.TS_HP_02_01;
import com.automationPractice.tests.homepage.smoke.TS_HP_02_02;
import com.automationPractice.tests.homepage.ui.TS_HP_02_03;
import com.automationPractice.tests.homepage.ui.TS_HP_03_04;

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
	public void testsHomePageSmoke() throws IOException {
		TS_HP_01_01 testCase01 = new TS_HP_01_01(driver, webSiteUrl);
		TS_HP_02_01 testCase02 = new TS_HP_02_01(driver, webSiteUrl);
		TS_HP_02_02 testCase03 = new TS_HP_02_02(driver, webSiteUrl);
	}
	
	@SuppressWarnings("unused")
	public void testsHomePageSanity() throws IOException {
		TS_HP_03_01 testCase05 = new TS_HP_03_01(driver, webSiteUrl);
		TS_HP_03_02 testCase06 = new TS_HP_03_02(driver, webSiteUrl);
		TS_HP_03_03 testCase07 = new TS_HP_03_03(driver, webSiteUrl);
	}
	
	@SuppressWarnings("unused")
	public void testsHomePageUI() throws IOException {
		TS_HP_02_03 testCase04 = new TS_HP_02_03(driver, webSiteUrl);
		TS_HP_03_04 testCase08 = new TS_HP_03_04(driver, webSiteUrl);
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
		TestsRunner runner = new TestsRunner();
 	    runner.setup();
// 	    runner.testsHomePageSmoke();
// 	    runner.testsHomePageSanity();
// 	    runner.testsHomePageUI();
 	    runner.testsDressesSummerPageSmoke();
	    runner.testsDressesSummerPageSanity();
	    runner.testsDressesSummerPageUI();
	    runner.testsCheckoutPageSmoke();
 	    runner.testsCheckoutPageSanity();
 	    runner.testsCheckoutPageUI();
	    runner.tearDown();
	    System.out.println("Tests Are Complete");
//		ExcelFileHandling fileHandler = new ExcelFileHandling("resource\\testData\\testData.xlsx", "Dashboard", "TS_HP_DL_01" );
//		fileHandler.readTestData();
//		for ( String key : fileHandler.getTestData().keySet() ) {
//		    System.out.println( key+" : "+ fileHandler.getTestData().get(key));
//		}
//		fileHandler.writeTestResult("PASS");
//		fileHandler.closeFile();
	}
}
