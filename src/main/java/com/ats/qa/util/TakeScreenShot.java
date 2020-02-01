package com.ats.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

@SuppressWarnings("serial")
public class TakeScreenShot implements  ITestResult {
	
	WebDriver driver = null;
	String filePath = "C:\\Users\\owner\\workspace\\ATS\\src\\main\\java\\com\\ats\\qa\\screenshot\\";

	public void takeScreenShot(WebDriver driver,String methodName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test
		// method name
		
		String fileName = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
		
		try {
			FileUtils.copyFile(scrFile, new File(filePath + methodName + "_"+ fileName));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure1(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}


	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	public void setAttribute(String name, Object value) {
		// TODO Auto-generated method stub
		
	}


	public Set<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}


	public Object removeAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	public int compareTo(ITestResult o) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getStatus() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setStatus(int status) {
		// TODO Auto-generated method stub
		
	}


	public ITestNGMethod getMethod() {
		// TODO Auto-generated method stub
		return null;
	}


	public Object[] getParameters() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setParameters(Object[] parameters) {
		// TODO Auto-generated method stub
		
	}


	public IClass getTestClass() {
		// TODO Auto-generated method stub
		return null;
	}


	public Throwable getThrowable() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setThrowable(Throwable throwable) {
		// TODO Auto-generated method stub
		
	}


	public long getStartMillis() {
		// TODO Auto-generated method stub
		return 0;
	}


	public long getEndMillis() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void setEndMillis(long millis) {
		// TODO Auto-generated method stub
		
	}


	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean isSuccess() {
		// TODO Auto-generated method stub
		return false;
	}


	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}


	public Object getInstance() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getTestName() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getInstanceName() {
		// TODO Auto-generated method stub
		return null;
	}


	public ITestContext getTestContext() {
		// TODO Auto-generated method stub
		return null;
	}


	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
}