package com.mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author SunkaraRam
 *
 */
public class BasePage extends Page {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getPageTitle() {
		
		return driver.getTitle();	
		
		
	}

	@Override
	public String getPageHeader(By locator) {
		
		return getElement(locator).getText();
		
	}

	@Override
	public WebElement getElement(By locator) {
		
		waitForElementPresent(locator);
		
		WebElement element = null;
		
		try {
			
			element = driver.findElement(locator);
		
			 return element;
		} 
		catch (Exception e) {
		
			System.out.println("Some error occured while creating element"+locator.toString());
		
			e.printStackTrace();
		}
		
		return null;
		
	}

	@Override
	public void waitForElementPresent(By locator) {
		
		try {
	
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (Exception e) {
			
			System.out.println("Some exception or error occured while waiting for element"+locator.toString());
			e.printStackTrace();
			
		}

		
		
	}

	@Override
	public void waitForPageTitle(String title) {
	
		try {
			
		 wait.until(ExpectedConditions.titleContains(title));
	

		} catch (Exception e) {
		
			System.out.println("");
			e.printStackTrace();
			
		}
		}

	@Override
	public void ActionsPerf(By locator) {

		Actions act = new Actions(driver);
		
		act.moveToElement((WebElement) locator).build().perform();;
		
	}

	
	
	
	
}
