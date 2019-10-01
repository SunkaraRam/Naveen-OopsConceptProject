package com.mypackage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base extends BasePage{
	
	
	
	public Base(WebDriver driver) {
		super(driver);

	}

	public void failed(String testMethodName) throws Throwable {
		
		try {
			
		
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(srcfile, new File("D:\\TestNGPrograms\\TCFailedScreenShots\\"+testMethodName+"_"+".jpg"));
		
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
	}
}
