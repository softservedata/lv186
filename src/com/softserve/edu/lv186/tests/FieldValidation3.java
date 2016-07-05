package com.softserve.edu.lv186.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.lv186.utils.ColorConverter;

public class FieldValidation3 {

	private WebDriver driver;

	@DataProvider(name = "args")
	public Object[][] dataFunction() {
		return new String[][] {
				{ "http://commentssprintone.azurewebsites.net/", "//*[@id='newbutton']",
						"http://commentssprintone.azurewebsites.net/Editor/NewComment" },
				{ "http://comments.azurewebsites.net", "//*[@id='command-navigation']/input[1]",
						"http://comments.azurewebsites.net/Editor/NewComment" } };
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
	public void testFV3(String url, String newButton, String newURl) {
		String name = "asfghasfghasfghasfghasfghasfghasfghasfghasfghasfghz";
		driver.get(url);
		driver.findElement(By.xpath(newButton)).click();
		driver.findElement(By.id("Text")).sendKeys(name);
		driver.findElement(By.xpath("//*[@id='editor-navigation']/input[1]")).click();
		String currentURL = driver.getCurrentUrl();
		Assert.assertEquals(currentURL, newURl);
		boolean text = driver.getPageSource().contains("The maximum length of Comment Text field is 50 characters");
		Assert.assertEquals(text, true);
		String backColor = driver.findElement(By.id("Text")).getCssValue("background-color");
		backColor = ColorConverter.rgbToHEX(backColor);
		Assert.assertEquals(backColor, "#ffeeee");
		String textColor = driver.findElement(By.className("field-validation-error")).getCssValue("color");
		textColor = ColorConverter.rgbToHEX(textColor);
		Assert.assertEquals(textColor, "#ff0000");
	}
}
