package com.mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author SunkaraRam
 *
 */
public class LoginPage extends BasePage{
	
	private By uid = By.xpath("//input[@id='username']");
	
	private By pwd = By.xpath("//input[@id='password']");
	
	private By loginBtn = By.xpath("//button[@id='loginBtn']");
	
	private By header = By.xpath("//i18n-string[contains(text(),\"Don't have an account?\")]");
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		}
	/**
	 * @return the uid
	 */
	public WebElement getUid() {
		return getElement(uid);
	}

	/**
	 * @return the pwd
	 */
	public WebElement getPwd() {
		return getElement(pwd);
	}
	
	/**
	 * @return the loginBtn
	 */
	public WebElement getLoginBtn() {
		return getElement(loginBtn);
	}
	
	public String getloginPageTitle() {
		
		return getPageTitle();
	}
	
	public String getLoginPageHeader() {
		
		return getElement(header).getText();
	}
	
	
	public HomePage doLogin(String username,String password) {
		
		getUid().sendKeys(username);
		getPwd().sendKeys(password);
		getLoginBtn().click();
		
		return getInstance(HomePage.class);
		
	}
	

}
