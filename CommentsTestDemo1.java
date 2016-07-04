package gmail.com.demo;

import static gmail.com.demo.Randomizer.getRand;
import static gmail.com.demo.Randomizer.getRandomCSS;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import gmail.com.demo.IBrowser.BrowsersList;

public class CommentsTestDemo1 {

	/*
	 * Selenium WebDriver with which all test methods works.
	 */
	WebDriver driver;
	WebDriverWait wait;

	/**
	 * Closes the browser, after each test method have been executed.
	 */
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		driver.quit();
	}

	/**
	 * Supplies the test methods with data needed.
	 * 
	 * @param method
	 *            reflects the test method, using Java Reflection API, on which
	 *            method data provider has been invoked and so the @return
	 *            differs.
	 * @return the array of arrays of data for each test method.
	 */
	@DataProvider
	public Object[][] TestData(Method method) {
		if (method.getName().equals("duplicateTest1")
				|| method.getName().equals("duplicateTest2")
				|| method.getName().equals("duplicateTest3")
				|| method.getName().equals("duplicateTest5")
				|| method.getName().equals("duplicateTest6")
				|| method.getName().equals("duplicateTest7")
				|| method.getName().equals("duplicateTest8")) {
			return new Object[][] {
					{
							BrowsersList.FIREFOX_TEMPORARY,
							new String(
									"http://commentssprintone.azurewebsites.net"), },
					{ BrowsersList.CHROME_TEMPORARY,
							new String("http://comments.azurewebsites.net") } };
		} else if (method.getName().equals("duplicateTest4")) {
			return new Object[][] {
					{
							BrowsersList.FIREFOX_TEMPORARY,
							new String(
									"http://commentssprintone.azurewebsites.net"),
							new String(
									"Comment Text,Number,Active,Категории,Available Categories,Selected Categories,Cat0,Cat1,Cat2,Cat3,Cat4,Cat5") },
					{
							BrowsersList.CHROME_TEMPORARY,
							new String("http://comments.azurewebsites.net"),
							new String(
									"Comment Text,Number,Active,Категории,Available Categories,Selected Categories,Cat0,Cat1,Cat2,Cat3,Cat4,Cat5") } };
		} else
			return new Object[][] { { null } };
	}

	/**
	 * Tests the appearance of pop-up message when no checkbox i.e. comment is
	 * selected.
	 * 
	 * @param browsers
	 *            provides WebDriver for Firefox and Chrome browsers.
	 * @param url
	 *            provides the URLs for Comments Application.
	 */
	@Test(dataProvider = "TestData", groups = "Clickg the 'Duplicate' link")
	public void duplicateTest1(BrowsersList browsers, String url) {
		/*
		 * message to check.
		 */
		String message;
		driver = browsers.getWebDriver();
		driver.get(url);
		/*
		 * Due to different realization of pop-up messages differs the hooking
		 * of message.
		 */
		if (url.equals("http://commentssprintone.azurewebsites.net")) {
			/*
			 * Finds the 'Duplicate' link and clicks it.
			 */
			driver.findElement(
					By.cssSelector("#command-navigation .buttonAsLink:nth-child(2)"))
					.click();
			/*
			 * Hooks the alert.
			 */
			Alert alert = driver.switchTo().alert();
			message = alert.getText();
			alert.accept();
			Assert.assertEquals(message, "Please, select one category");
		} else {
			/*
			 * Finds the 'Duplicate' link and clicks it.
			 */
			driver.findElement(
					By.cssSelector("#command-navigation .buttonAsLink:nth-child(2)"))
					.click();
			/*
			 * Hooks the pop-up div.
			 */
			message = driver.findElement(By.id("msgText")).getText();
			driver.findElement(By.cssSelector("button.ui-button")).sendKeys(
					"Enter");
			Assert.assertEquals(message, "Please select one comment");
		}
	}

	/**
	 * Tests the the appearance of pop-up message when several checkboxes i.e.
	 * comments are selected.
	 * 
	 * @param browsers
	 *            provides WebDriver for Firefox and Chrome browsers.
	 * @param url
	 *            provides the URLs for Comments Application.
	 */
	@Test(dataProvider = "TestData", groups = "Clickg the 'Duplicate' link")
	public void duplicateTest2(BrowsersList browsers, String url) {
		String message;
		driver = browsers.getWebDriver();
		driver.get(url);
		if (url.equals("http://commentssprintone.azurewebsites.net")) {
			driver.findElement(By.cssSelector(getRandomCSS())).click();
			driver.findElement(By.cssSelector(getRandomCSS())).click();
			driver.findElement(
					By.cssSelector("#command-navigation .buttonAsLink:nth-child(2)"))
					.click();
			Alert alert = driver.switchTo().alert();
			message = alert.getText();
			alert.accept();
			Assert.assertEquals(message, "Please, select one category");
		} else {
			driver.findElement(By.linkText("Number")).click();
			driver.findElement(By.cssSelector(getRandomCSS())).click();
			driver.findElement(By.cssSelector(getRandomCSS())).click();
			driver.findElement(
					By.cssSelector("#command-navigation .buttonAsLink:nth-child(2)"))
					.click();
			message = driver.findElement(By.id("msgText")).getText();
			driver.findElement(By.cssSelector("button.ui-button")).sendKeys(
					"Enter");
			Assert.assertEquals(message, "Please select one comment");
		}
	}

	@Test(dataProvider = "TestData", groups = "Clickg the 'Duplicate' link")
	public void duplicateTest3(BrowsersList browsers, String url) {
		driver = browsers.getWebDriver();
		driver.get(url);
		if (url.equals("http://comments.azurewebsites.net")) {
			driver.findElement(By.linkText("Number")).click();
		}
		driver.findElement(By.cssSelector(getRandomCSS())).click();
		driver.findElement(
				By.cssSelector("#command-navigation .buttonAsLink:nth-child(2)"))
				.click();
		String expected = url + "/Editor/DuplicateComment";
		Assert.assertEquals(driver.getCurrentUrl(), expected);
	}

	@Test(dataProvider = "TestData")
	public void duplicateTest4(BrowsersList browsers, String url,
			String expected) {
		driver = browsers.getWebDriver();
		driver.get(url);
		List<String> expectedList = Arrays.asList(expected.split(","));

		if (url.equals("http://comments.azurewebsites.net")) {
			driver.findElement(By.linkText("Number")).click();
			expectedList.set(3, "Categories");
		}
		driver.findElement(By.cssSelector(getRandomCSS())).click();
		driver.findElement(
				By.cssSelector("#command-navigation .buttonAsLink:nth-child(2)"))
				.click();

		List<WebElement> list = driver.findElements(By.xpath("//label[@for] "
				+ "| //div[@class='category-list-title'] "
				+ "| //div[@class='categoryitem']/span"));
		StringBuilder sb = new StringBuilder();

		for (WebElement w : list) {
			sb.append(w.getText() + ",");
		}
		String builtActual = sb.toString();

		List<String> actualList = Arrays.asList(builtActual.split(","));
		Assert.assertTrue(actualList.containsAll(expectedList));
	}

	@Test(dataProvider = "TestData")
	public void duplicateTest5(BrowsersList browsers, String url) {
		driver = browsers.getWebDriver();
		driver.get(url);
		if (url.equals("http://comments.azurewebsites.net")) {
			driver.findElement(By.linkText("Number")).click();
		}
		driver.findElement(By.cssSelector(getRandomCSS())).click();
		driver.findElement(
				By.cssSelector("#command-navigation .buttonAsLink:nth-child(2)"))
				.click();
		List<WebElement> elementsList = driver.findElements(By
				.xpath("//input[@id='Text']" + "|//input[@id='Number']"
						+ "|//input[@id='Active']"
						+ "|//input[@name='AllSelect']"
						+ "|//input[@name='CurSelect']"
						+ "|//input[@name='CurUnSelectBtn']"
						+ "|//input[@name='AllUnSelectBtn']"));

		for (WebElement e : elementsList) {
			Assert.assertTrue(e.isDisplayed());
		}

	}

	

	@Test(dataProvider = "TestData")
	public void duplicateTest6(BrowsersList browsers, String url) {
		driver = browsers.getWebDriver();
		driver.get(url);
		if (url.equals("http://comments.azurewebsites.net")) {
			driver.findElement(By.linkText("Number")).click();
		}

		driver.findElement(By.cssSelector(getRandomCSS())).click();

		driver.findElement(
				By.cssSelector("#command-navigation .buttonAsLink:nth-child(2)"))
				.click();

		List<String> beforeStatus = new ArrayList<String>();
		beforeStatus.add(driver.findElement(By.cssSelector("#Text"))
				.getAttribute("value"));
		beforeStatus.add(driver.findElement(By.cssSelector("#Number"))
				.getAttribute("value"));
		beforeStatus.add(driver.findElement(By.cssSelector("#Active"))
				.getAttribute("value"));

		List<WebElement> selectedCategories = driver.findElements(By
				.cssSelector("div#selectedCategories input#Categories"));
		for (WebElement e : selectedCategories) {
			beforeStatus.add(e.getAttribute("value"));
		}

		driver.findElement(By.cssSelector("#Text")).sendKeys("Blah-blah-blah");
		driver.findElement(By.cssSelector("#Number")).sendKeys(
				String.valueOf(getRand().nextInt(10)));
		driver.findElement(By.cssSelector("#Active")).click();
		driver.findElement(By.cssSelector("input[value='>>']")).click();
		/*
		 * Click 'Refresh' button.
		 */
		driver.findElement(By.xpath("//div[@id='editor-navigation']/*[1]"))
				.click();

		List<String> afterStatus = new ArrayList<String>();
		afterStatus.add(driver.findElement(By.cssSelector("#Text"))
				.getAttribute("value"));
		afterStatus.add(driver.findElement(By.cssSelector("#Number"))
				.getAttribute("value"));
		afterStatus.add(driver.findElement(By.cssSelector("#Active"))
				.getAttribute("value"));

		List<WebElement> selectedCategories2 = driver.findElements(By
				.cssSelector("div#selectedCategories input#Categories"));
		for (WebElement e : selectedCategories2) {
			afterStatus.add(e.getAttribute("value"));
		}

		Assert.assertEquals(beforeStatus, afterStatus);
	}
	
	@Test(dataProvider = "TestData", groups = "Saving the dublicate comment")
	public void duplicateTest7(BrowsersList browsers, String url) {
		driver = browsers.getWebDriver();
		driver.get(url);

		if (url.equals("http://comments.azurewebsites.net")) {
			driver.findElement(By.linkText("Number")).click();
		}

		driver.findElement(By.cssSelector(getRandomCSS())).click();
		
		driver.findElement(
				By.cssSelector("#command-navigation .buttonAsLink:nth-child(2)"))
				.click();
		driver.findElement(By.cssSelector("#editor-navigation :nth-child(3)")).click();
		
		Assert.assertTrue(driver.findElement(By.id("errorfield")).isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase(url+"/Editor/SaveReturn"));
	}

	@Test(dataProvider = "TestData", groups = "Saving the dublicate comment")
	public void duplicateTest8(BrowsersList browsers, String url) {
		driver = browsers.getWebDriver();
		driver.get(url);

		if (url.equals("http://comments.azurewebsites.net")) {
			driver.findElement(By.linkText("Number")).click();
		}

		driver.findElement(By.cssSelector(getRandomCSS())).click();
		driver.findElement(
				By.cssSelector("#command-navigation .buttonAsLink:nth-child(2)"))
				.click();
		String original = driver.findElement(By.cssSelector("#Text")).getAttribute("value");
		driver.findElement(By.cssSelector("#Number")).clear();
		driver.findElement(By.cssSelector("#Number")).sendKeys(
				String.valueOf(getRand().nextInt(1000) + 30));
		driver.findElement(By.cssSelector("#editor-navigation :nth-child(3)")).click();

		if (url.equals("http://comments.azurewebsites.net")) {
			driver.findElement(By.linkText("Number")).click();
		}
		boolean isWebElementFound = false;
		List<WebElement> duplicatComments = null;
		List<WebElement> originalComments = null;
		WebElement duplicateComment = null;
		while (!isWebElementFound) {
			duplicatComments = driver.findElements(By
					.xpath("//td[contains(text(),'Copy of')]"));
			originalComments = driver.findElements(By
					.xpath("//td[contains(text(), '"+original+"')]"));
			if (duplicatComments.size() > 0) {
				isWebElementFound = true;
				duplicateComment = duplicatComments.get(0);
			} else {
				List<WebElement> next = driver.findElements(By.linkText(">"));
				if (next.size() > 0) {
					next.get(0).click();
				} else {
					break;
				}
			}
		}
		Assert.assertTrue(originalComments.get(0).isDisplayed());
		Assert.assertTrue(duplicateComment.isDisplayed());
	}

}
