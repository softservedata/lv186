package com.softserve.edu.homeTestCase6;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.reporters.Files;

public class TestBase extends ConciseAPI {
	static WebDriver driver = new FirefoxDriver();
	private boolean isTestCompleted = false;

	@AfterMethod
	public void getScreenshot(ITestResult testResult) throws IOException {
		// if (!isTestCompleted) {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

			FileUtils.copyFile(scrFile, new File("./screenshots" + timeStamp + ".png"));
		}
		// }
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

	public void waitFor() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
