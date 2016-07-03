package com.softserve.edu.homeTestCase6;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends TestBase {
	Page page = new Page(driver);

	@Test(dataProvider="differentUrls", dataProviderClass = Providers.class)
	public void TestCase5(String url) throws InterruptedException {
		page.visit(url);
		waitFor();
		page.clickCheckButton();
		page.clickEditButton();
		page.getTextFromTheField();
		page.clickReturnButton();
		page.clickNewButton();
		page.inputTextAndChangeSymbols();
		page.clickSaveButton();
		Assert.assertTrue(page.getErrorFieldText2().contains("already exists"), "Error: another text");
		Assert.assertEquals(page.getCssvalue(), "#FF0000", "Error: another color");

	}

}
