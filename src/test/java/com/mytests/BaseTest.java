
package com.mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypackage.BasePage;
import com.mypackage.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author SunkaraRam
 *
 */
public class BaseTest {
	
	WebDriver driver;
	
	public Page page;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void setUpTest(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			
			//WebDriverManager.chromedriver().setup();
			
			System.setProperty("webdriver.chrome.driver", "d://chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("No browser is defined in xml file");
		}
		
		driver.get("https://app.hubspot.com/login/");
		
		try { 
			Thread.sleep(6000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		
		page = new BasePage(driver);
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
}
