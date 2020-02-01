package com.ats.qa.test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
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
		String expectedUrl = prop.getProperty("targetedUrl");
		Assert.assertTrue(currentUrl.contains(expectedUrl), "Failed to create a project!");
	}

	@AfterMethod
	public void tearDown(ITestResult results) {

		if (ITestResult.FAILURE == results.getStatus()) {
			tssh.takeScreenShot(driver, results.getName());
		}
		driver.quit();
	}

}
