package com.ats.qa.pages;

import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ats.qa.base.TestBase;

public class ProjectPage extends TestBase {

	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();

	@FindBy(xpath = "//label[text()='Internal No. (if applicable)']//following::input[1]")
	WebElement InternalNo;

	@FindBy(xpath = "//label[text()='Project Name *']//following::input[1]")
	WebElement projectname;

	@FindBy(xpath = "//label[text()='Country *']//following::input[1]")
	WebElement country;

	@FindBy(xpath = "//span[text()='Algeria']")
	WebElement algeria;

	@FindBy(xpath = "//label[text()='State/Province *']//following::input[1]")
	WebElement stateprovince;

	// dorp down list for state/province
	@FindBy(xpath = "//label[text()='State/Province *']/following::ul")
	List<WebElement> stateprovinceDropDown;

	@FindBy(xpath = "//span[text()='Adrar']")
	WebElement adrar;

	// City
	@FindBy(xpath = "//label[text()='City *']//following::input[1]")
	WebElement city;

	// dorp down list for state/province
	@FindBy(xpath = "//label[text()='City *']/following::ul")
	List<WebElement> cityDropDown;

	@FindBy(xpath = "//li[@id='react-autowhatever-1--item-2']")
	WebElement specificCity;

	@FindBy(xpath = "//label[text()='Address']//following::textarea[1]")
	WebElement address;

	// Bid Date
	@FindBy(xpath = "//label[text()='Bid Date *']//following::input[1]")
	WebElement biddate;

	// Area
	@FindBy(xpath = "//label[text()='Area (in sq. ft.) *']//following::input[1]")
	WebElement area;

	// Next button
	@FindBy(xpath = "//span[text()='Next']")
	WebElement nextBtn;

	@FindBy(xpath = "//p[text()='Education']")
	WebElement buildingclass;

	@FindBy(xpath = "//span[text()='Day Care']")
	WebElement buildingtype;

	@FindBy(xpath = "//span[text()='Finish']")
	WebElement finish;

	// Next button
	@FindBy(xpath = "/html/body/div[3]/div[3]/div/div[2]/div/div[3]/div/div/div/div/div/div/form/div[4]/button[2]/span[1]")
	WebElement nextBtn2;

	public ProjectPage() {
		PageFactory.initElements(driver, this);
	}

	public String FillForm(String userName, String userPwd) throws InterruptedException {

		// login with correct credential
		loginPage.login(userName, userPwd);

		// Create a project
		homePage.clickCreateNewProject();

		// Fill the fields to creating project
		clickOn(driver, InternalNo, 3000);
		InternalNo.sendKeys(prop.getProperty("InternalNo"));

		projectname.click();
		projectname.sendKeys(prop.getProperty("projectname"));

		country.click();
		algeria.click();

		clickOn(driver, stateprovince, 2000);
		Thread.sleep(2000);

		// For the dropdown list for state/province is not show up
		if (stateprovinceDropDown.size() <= 0) {
			address.click();
			stateprovince.click();
		}

		adrar.click();

		clickOn(driver, city, 3000);
		city.sendKeys("h");
		
		// For the dropdown list for city is not show up
		if (cityDropDown.size() <= 0) {
			address.click();
			city.click();
			city.sendKeys("h");
		}
		Thread.sleep(2000);
		clickOn(driver, specificCity, 3000);

		clickOn(driver, address, 3000);
		address.sendKeys(prop.getProperty("address"));

		biddate.click();
		biddate.sendKeys(prop.getProperty("biddate"));

		area.click();
		area.sendKeys(prop.getProperty("area"));

		nextBtn.click();

		clickOn(driver, buildingclass, 3000);
		buildingtype.click();
		nextBtn2.click();

		finish.click();
		Thread.sleep(6000);

		return driver.getCurrentUrl();
	}

	// Explicit wait: for the specific element
	public static void clickOn(WebDriver driver, WebElement locator, int timeout) {
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
}
