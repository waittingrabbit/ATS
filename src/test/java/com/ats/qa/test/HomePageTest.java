package com.ats.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ats.qa.base.TestBase;
import com.ats.qa.pages.HomePage;
import com.ats.qa.pages.LoginPage;
import com.ats.qa.util.TakeScreenShot;

public class HomePageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	TakeScreenShot tssh;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		// call parent method here
		initializaion();
		driver.get(prop.getProperty("url"));
		homePage = new HomePage();
		loginPage = new LoginPage();
		tssh = new TakeScreenShot();
	}

	@Test(priority = 1)
	public void changeToPageNewProjectTest() {
		HomePage homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String url = homePage.createNewProject();
		if (!url.equals("https://spec.atsspecsolutions.com/createNewProject")) {
			tssh.takeScreenShot("changeToPageNewProjectTest", driver);
		}
		Assert.assertEquals(url, "https://spec.atsspecsolutions.com/createNewProject");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
