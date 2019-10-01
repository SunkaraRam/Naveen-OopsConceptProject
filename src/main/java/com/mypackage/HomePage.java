/**
 * 
 */
package com.mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author SunkaraRam
 *
 */
public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By homeheader = By.xpath("//h1[@class='private-page__title']");
	
	private By report = By.xpath("//button[@id='add-report']");
	
	public WebElement homePageHeade() {
		
		return getElement(homeheader);
	}
	
	public String homePageTitle() {
		
		return driver.getTitle();
		
	}
	
	public String checkReport() {
		
		ActionsPerf(report);
		
		getElement(report).click();
		return null;
		
	}
	
	
	
	
}
