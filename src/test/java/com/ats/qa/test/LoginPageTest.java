package com.ats.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ats.qa.base.TestBase;
import com.ats.qa.pages.HomePage;
import com.ats.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
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
	}
	
	@Test(priority=1)
	public void loginTest()
	{
		HomePage homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals("Spec Tool", homePage.validateHomePageTitle());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
