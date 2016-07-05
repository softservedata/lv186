package com.softserve.edu.lv186.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FieldValidation4 {
	private WebDriver driver;

	@DataProvider(name = "args")
	public Object[][] dataFunction() {
		return new String[][] { { "http://commentssprintone.azurewebsites.net/", "//*[@id='newbutton']" },
				{ "http://comments.azurewebsites.net", "//*[@id='command-navigation']/input[1]" } };
	}

	@BeforeClass
	public void setUp() {
		// driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "test\\chromedriver.exe");
		driver = new ChromeDriver();
		//
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test(dataProvider = "args")
	public void testFV4(String url, String newButton) throws Exception {
		boolean nextPagePresent = true;
		String name = "asfghasfghasfghasfghasfghasfghasfghasfghasfghasfgh";
		driver.get(url);
		driver.findElement(By.xpath(newButton)).click();
		driver.findElement(By.id("Text")).sendKeys(name);
		driver.findElement(By.name("AllSelect")).click();
		driver.findElement(By.xpath("//*[@id='editor-navigation']/input[1]")).click();
		driver.findElement(By.cssSelector("#logindisplay > a")).click();
		while (nextPagePresent) {
			if (driver.getPageSource().contains(name)) {
				break;
			}
			if ((driver.findElements(By.linkText(">")).size()) == 0) {
				throw new NoSuchElementException(name);
			}
			driver.findElement(By.linkText(">")).click();
		}
	}
}
