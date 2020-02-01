package com.ats.qa.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ats.qa.base.TestBase;
import com.ats.qa.pages.ProjectPage;
import com.ats.qa.util.TakeScreenShot;

public class ProjectPageTest extends TestBase {

	// LoginPage carbonIpmactPage;
	ProjectPage projectPage;
	TakeScreenShot tssh;

	@BeforeMethod
	public void setUp() {
		// call parent method here
		initializaion();
		driver.get(prop.getProperty("url"));
		projectPage = new ProjectPage();
		tssh = new TakeScreenShot();
	}

	@Test(priority = 1)
	public void projectCreationTest() throws InterruptedException, IOException {
		String currentUrl = projectPage.FillForm(prop.getProperty("username"), prop.getProperty("password"));
		/*
		 * System.out.println( "After click Finish button, the url is >>" +
		 * currentUrl);
		 */
		String expectedUrl = prop.getProperty("targetedUrl");

		// Failed to take screenshot
		if (!currentUrl.contains(expectedUrl)) {
			tssh.takeScreenShot("projectCreationTest", driver);
		}
		Assert.assertTrue(currentUrl.contains(expectedUrl), "Failed to create a project!");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
