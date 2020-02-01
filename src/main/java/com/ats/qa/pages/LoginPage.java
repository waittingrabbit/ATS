package com.ats.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ats.qa.base.TestBase;
import com.ats.qa.pages.HomePage;

public class LoginPage extends TestBase {
	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement passWord;

	@FindBy(xpath="//span[text()='Login']")
	WebElement loginBtn;

	// Initializing the page objects
	 public LoginPage() {
		PageFactory.initElements(driver, this); // the login page will be
												// initialized by the driver
	}

	// Actions: validate title
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String userEmail, String userPwd) {
		userName.sendKeys(userEmail);
		passWord.sendKeys(userPwd);
		loginBtn.click();

		// return HomePage after click login with correct credencial
		return new HomePage();
	}
}
