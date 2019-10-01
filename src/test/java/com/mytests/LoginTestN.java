package com.mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mypackage.HomePage;
import com.mypackage.LoginPage;

public class LoginTestN extends BaseTest {

	@Test(enabled=false)
	public void verifyLogin() {
		
		LoginPage lp = new LoginPage(driver);
		
		String lptitle = lp.getloginPageTitle();
		
		System.out.println(lptitle);
		
		Assert.assertEquals("HubSpot Login",lptitle);
	}
	
	@Test(enabled=false)
	public void verifyLoginPageHeaderTEst() {
		
		String lpheader = page.getInstance(LoginPage.class).getLoginPageHeader();
		
		System.out.println(lpheader);
		
		Assert.assertEquals("Don't have an account?", lpheader);
		
	}
	
	@Test(retryAnalyzer=ImplementationS.RetryAnalyzer.class)
	public void verifydoLoginTest() throws InterruptedException {
		
		HomePage hompage = page.getInstance(LoginPage.class).doLogin("naveenanimation20@gmail.com", "Test@12345");
		
		String homeheader = hompage.homePageHeade().getText();

		System.out.println(homeheader);
		
		Assert.assertEquals(homeheader, "Sales Dashboard");
		
		Thread.sleep(5000);
		
		page.getInstance(HomePage.class).checkReport();
	
	
	}
	
}
