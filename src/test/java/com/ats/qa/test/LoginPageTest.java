package com.ats.qa.test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ats.qa.base.TestBase;
import com.ats.qa.pages.HomePage;
import com.ats.qa.pages.LoginPage;
import com.ats.qa.util.TakeScreenShot;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TakeScreenShot tssh;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		//call parent method here
		initializaion();
		driver.get(prop.getProperty("url"));
		
		loginPage = new LoginPage();
		homePage = new HomePage();
		tssh = new TakeScreenShot();
	}
	
	@Test(priority=1)
	public void loginTest()
	{
		HomePage homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePage.elementIsDisplayed(), true);
	}
	
	@AfterMethod
	public void tearDown(ITestResult results) {
		if (ITestResult.FAILURE == results.getStatus()) {
			tssh.takeScreenShot(driver, results.getName());
		}
		driver.quit();
	}

}
