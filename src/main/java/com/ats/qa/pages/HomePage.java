package com.ats.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats.qa.base.TestBase;

public class HomePage extends TestBase {
	
	// Page Factory - Object Repository:
	@FindBy(xpath = "//span[text()='New Project']")
	WebElement newProject;
	
	
	// Initializing the page objects
	public HomePage()
	{
		PageFactory.initElements(driver, this); // the home page will be initialized by the driver
	}
	
	//Actions: validate title
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String validateHomePageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String createNewProject()
	{
		newProject.click();
		String url = driver.getCurrentUrl();
		//System.out.println(url);
		return url;
	}
	
	public void clickCreateNewProject()
	{
		newProject.click();
	}
	
	public 	boolean elementIsDisplayed()
	{
		return newProject.isDisplayed();
	}
}
