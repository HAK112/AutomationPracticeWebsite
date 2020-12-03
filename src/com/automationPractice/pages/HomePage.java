package com.automationPractice.pages;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

public class HomePage {
	WebDriver driver;
	Actions builder;
	
	//Women Nav Bar Element
	@FindBy(xpath="//a[@title='Women']")
	WebElement womenNavbarElement;
	
	//Dresses sub Menu Element
	@FindBy(xpath="//li[@class='sfHover']//a[@title='Dresses']")
	WebElement dressesSubMenuNavbarElement;
	
	//Summer Dresses Element under Dresses Sub-Menu Nav Bar Element which is furthur under Women Nav Bar Element
	@FindBy(xpath="//li[@class='sfHover']//ul//li//a[contains(text(),'Summer Dresses')]")
	WebElement summerDressesSubMenuNavBarElement;
	
	//Dresses Nav Bar Element
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[2]/a")
	WebElement dressesNavbarElement;
			
	//Summer Dresses Item Element under Dresses Sub Menu Element
	@FindBy(xpath="//li[@class='sfHover']//ul//li//a[contains(text(),'Summer Dresses')]")
	WebElement summerDressesSubMenuItemElement;
	
	//Automation Practive Logo
	@FindBy(xpath="//img[@alt='My Store']")
	WebElement automationPracticeLogo;
	
	//Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		builder = new Actions(driver);
		PageFactory.initElements(driver, this);
	}
	
	//To Hover Over an Element
	public void hoverOverElement(WebElement hoverElement) {
		System.out.println("Hovering Over: "+hoverElement.getText()+"\n");
		builder.moveToElement(hoverElement).build().perform();
	}
	
	//Return the Title of the Page
	public String getPageTitle() {
		System.out.println("Getting Page Title");
		return driver.getTitle();
	}	
	
	//Clicks the upload file button
	public String getPageVerificationLogoAltText() {
		isLoaded(automationPracticeLogo);
		System.out.println("Getting the Page Verification Text");
		return automationPracticeLogo.getAttribute("alt");
	}
	
	//Get text for Women Element in Nav Bar
	public String getWomenNavBarText() {
		isLoaded(womenNavbarElement);
		return womenNavbarElement.getText();
	}
	
	//Get text for Dresses Sub Menu Element after Women Nav Bar Element
	public String getDressesSubMenuText() {
		hoverOverElement(womenNavbarElement);
		isLoaded(dressesSubMenuNavbarElement);
		return dressesSubMenuNavbarElement.getText();
	}
	
	//Get Text for Summer Dresses Element under Dresses Submenu which is furthur under Women Nav Bar Element
	public String getSummerDressesSubMenuItemText() {
		hoverOverElement(womenNavbarElement);
		isLoaded(summerDressesSubMenuItemElement);
		return summerDressesSubMenuItemElement.getText();
	}
	
	//Get text for Dresses for Nav Bar Element
	public String getDressesNavBarText() {
		isLoaded(dressesNavbarElement);
		return dressesNavbarElement.getText();
	}
	
	//Get Text for Summer Dresses Element under Dresses Nav Bar Element
	public String getSummerDressesSubMenuText() {
		hoverOverElement(dressesNavbarElement);
		isLoaded(summerDressesSubMenuNavBarElement);
		return summerDressesSubMenuNavBarElement.getText();
	}
	
	public void clickSummerDresses() {
		hoverOverElement(dressesNavbarElement);
		isLoaded(summerDressesSubMenuNavBarElement);
		System.out.println("Clicking on: Summer Dresses");
		summerDressesSubMenuItemElement.click();
	}
	
	//To check the element exists or not and using Fluent Wait to check for 30 sec max at the intervals of 1 sec
	@SuppressWarnings("deprecation")
	public void isLoaded(WebElement element) throws Error {
		new FluentWait<WebDriver>(driver)
        .withTimeout(30, TimeUnit.SECONDS)
        .pollingEvery(1, TimeUnit.SECONDS)
        .ignoring(NoSuchElementException.class)
        .ignoring(StaleElementReferenceException.class)
        .until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return element != null && element.isDisplayed();
            }
        });
	}
}
