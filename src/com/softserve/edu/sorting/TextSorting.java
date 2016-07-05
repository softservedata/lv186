package com.softserve.edu.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TextSorting {
	private WebDriver driver;

	@Test(dataProvider = "args")
	public void textSort(String url, Comparator<Object> reverseOrder, boolean ascendingOrder) {
		boolean nextPagePresent = true;
		driver.get(url);
		driver.findElement(By.linkText("Comment Text")).click();
		if (!ascendingOrder) {
			driver.findElement(By.linkText("Comment Text")).click();
		}
		List<String> textValues = new ArrayList<String>();
		while (nextPagePresent) {
			List<WebElement> current = driver.findElements(By.className("textcolumn"));
			for (WebElement webElement : current) {
				textValues.add(webElement.getText());
			}
			if ((driver.findElements(By.linkText(">")).size()) == 0) {
				nextPagePresent = false;
			} else {
				driver.findElement(By.linkText(">")).click();
			}
		}
		List<String> sortedText = new ArrayList<>(textValues);
		Collections.sort(sortedText, reverseOrder);
		Assert.assertEquals(textValues, sortedText, "Text is not sorted");
	}

	@DataProvider(name = "args")
	public Object[][] dataFunction() {
		return new Object[][] { 
				{ "http://commentssprintone.azurewebsites.net/", null, true },
				{ "http://commentssprintone.azurewebsites.net/", Collections.reverseOrder(), false },
				{ "http://comments.azurewebsites.net", null, false },
				{ "http://comments.azurewebsites.net", Collections.reverseOrder(), true } };
	}

	@Parameters({ "browsers" })
	@BeforeClass
	public void setUp(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "test\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("iexplorer")) {
			System.setProperty("webdriver.ie.driver", "test\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
