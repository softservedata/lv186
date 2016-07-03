package com.softserve.edu.TestFieldsInApp;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.apache.commons.io.FileUtils;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.TestFieldsInApp.IBrowser.BrowsersList;

public class NewCommentTest {
	private WebDriver driver;
	private Page page;

	@Test(dataProvider = "browsersAndUrls", groups = "NumberFieldTest")
	public void testWetherFieldsAreEmptyTC1(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		Assert.assertTrue(page.commentTextField.getText().isEmpty(), "It's not empty");
		Assert.assertTrue(page.numberField.getText().isEmpty(), "It's not empty");

	}

	@Test(dataProvider = "browsersAndUrls", groups = "NumberFieldTest")
	public void enterUniqueDataToTheCommentTextFieldTC2(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("zxcvb");
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		page.clickReturnButton();
		Assert.assertTrue(page.findUPtO50CharactersElementInTheList(), "Error: Element wasn't found");
	}

	@Test(dataProvider = "browsersAndUrls", groups = "NumberFieldTest")
	public void validationEmptyCommentTextFieldTC3(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.clickSaveButton();
		Assert.assertTrue(page.getErrorFieldText().contains("The Comment Text field is required"),
				"Error: Another text");
		Assert.assertEquals(page.getCssvalue(), "#ffeeee", "Error: Another color");
	}

	@Test(dataProvider = "browsersAndUrls", groups = "NumberFieldTest")
	public void minValueCommentTextFieldTC4(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("a");
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		page.clickReturnButton();
		Assert.assertTrue(page.find1CharacterElementInTheList(), "Error: Comment wasn't found");
	}

	@Test(dataProvider = "browsersAndUrls", groups = "NumberFieldTest")
	public void verifyMaxLengthCommentTextFieldTC5(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("zxcvbnmlkjhgfdsaqwertyuioplkjhgfdsazxcvbnmiuytrewq");
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		page.clickReturnButton();
		Assert.assertTrue(page.find50CharactersElementInTheList(), "Error: Comment wasn't found");
	}

	@Test(dataProvider = "browsersAndUrls", groups = "NumberFieldTest")
	public void moreThan50SymbolsInCommentTextFieldTC6(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("zxcvbnmlkjhgfdsaqwertyuioplkjhgfdsazxcvbnmiuytrewqa");
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		Assert.assertEquals(page.getErrorFieldText(), "The maximum length of Comment Text field is 50 characters",
				"Error: Another text");
		Assert.assertEquals(page.getCssvalue(), "#ffeeee", "Error: Another color");
	}

	@Test(dataProvider = "browsersAndUrls", groups = "NumberFieldTest")
	public void spacesInCommentTextFieldTC7(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("    ");
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		Assert.assertTrue(page.getErrorFieldText().contains("The Comment Text field is required"),
				"Error: Another text");
	}

	@Test(dataProvider = "browsersAndUrlsAndSymbols", groups = "NumberFieldTest")
	public void verifySpecialSymbolsInCommentTextFieldTC8(String url, BrowsersList browser, String symbol)
			throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField(symbol);
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		Assert.assertTrue(page.getErrorFieldText().contains("alphanumeric characters only"), "Error: Another text");
	}

	@Test(dataProvider = "browsersAndUrls", groups = "NumberFieldTest")
	public void verifyThatCommentTextFieldIsUniqueTC9(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.getTextFromTheField();
		page.clickReturnButton();
		page.clickNewButton();
		page.inputText();
		page.clickSaveButton();
		Assert.assertEquals(page.getErrorFieldText(), "Comment already exists", "Error: Another text");
		// Assert.assertEquals(page.getCssvalue(), "#ffeeee", "Error: Another
		// color");
	}

	@Test(dataProvider = "browsersAndUrls", groups = "NumberFieldTest")
	public void verifyThatCommentTextFieldIsUniqueViseVersaTC10(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.getTextFromTheField();
		page.clickReturnButton();
		page.clickNewButton();
		page.inputTextAndChangeSymbols();
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		Assert.assertTrue(page.getErrorFieldText().contains("already exists"), "Error: Another text");
		Assert.assertEquals(page.getCssvalue(), "#ffeeee", "Error: Another color");

	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyThatNumberFieldIsntObligatoryInCreatingTC11(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("zxcvb");
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		page.clickReturnButton();
		Assert.assertTrue(page.findUPtO50CharactersElementInTheList(), "Error: Comment wasn't found");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyThatNumberFieldAllowsAnySymbolUpTo999SmokeTC12(String url, BrowsersList browser)
			throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("zxcvb");
		page.enterDataToNumberField("998");
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		page.clickReturnButton();
		Assert.assertTrue(page.findUPtO50CharactersElementInTheList(), "Error: Comment wasn't found");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyThatNumberFieldDoesntAllowsAnyCharactersTC13(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("zxcvb");
		page.enterDataToNumberField("abc");
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		Assert.assertEquals(page.getErrorFieldText(), "Number field should contains only digits",
				"Error: Another text");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyThatNumberFieldDoesntAllowsAnySpecialCharactersTC14(String url, BrowsersList browser)
			throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("zxcvb");
		page.enterDataToNumberField(":]?");
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		Assert.assertEquals(page.getErrorFieldText(), "Number field should contains only digits",
				"Error: Another text");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyThatNumberCantBeBiggerThan999TC15(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("zxcvb");
		page.enterDataToNumberField("9988");
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		Assert.assertTrue(page.getErrorFieldText().contains("The Number field should contain value from 0 to 999"),
				"Error: Another text");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyThatNumberCantExcept0TC16(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.selecFirstCommentFromTheList();
		page.clickDeleteButton();
		page.clickYesButton();
		page.clickNewButton();
		page.enterDataToCommentTextField("zxcvb");
		page.enterDataToNumberField("0");
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		page.clickReturnButton();
		Assert.assertTrue(page.findUPtO50CharactersElementInTheList(), "Error: Comment wasn't found");

	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyThatNumberCanBe999TC17(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("zxcvb");
		page.enterDataToNumberField("999");
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		page.clickReturnButton();
		Assert.assertTrue(page.findUPtO50CharactersElementInTheList(), "Error: Comment wasn't found");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyThatNumberCanBe1000TC18(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("zxcvb");
		page.enterDataToNumberField("1000");
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		Assert.assertTrue(page.getErrorFieldText().contains("from 0 to 999 and should be unique"),
				"Error: Another text");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void numberFieldUniqueValidationTC19(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.getNumberFromTheNumberField();
		page.clickReturnButton();
		page.clickNewButton();
		page.enterDataToCommentTextField("zxcvb");
		page.inputNumber();
		page.clickSaveButton();
		Thread.sleep(2000);
		Assert.assertEquals(page.getErrorFieldText(), "Number field should be unique of empty", "Error: Another text");

	}

	// @Test(dataProvider = "browsersAndUrls")
	public void activeCheckIsCheckedByDefaultTC20(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		Assert.assertTrue(page.activeCheckButton.isSelected(), "Error: Check isn't selected");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void veryfyThatActiveChekboxCanBeChackedAndUncheckedTC21(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.clickActiveButton();
		Assert.assertFalse(page.activeCheckButton.isSelected(), "Error: Check is selected");

	}

	// @Test(dataProvider = "browsersAndUrls")
	public void veryfyThatNewCommentCanBeCreatedWithUncheckedActiveTC22(String url, BrowsersList browser)
			throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("zxcvb");
		page.clickActiveButton();
		page.moveOneCategoryToTheRight();
		page.clickSaveButton();
		page.clickReturnButton();
		Assert.assertTrue(page.findUPtO50CharactersElementInTheList(), "Error: Comment wasn't found");

	}

	// @Test(dataProvider = "browsersAndUrls")
	public void categoryNotEmptyValidationTC23(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.enterDataToCommentTextField("gyfdtysztez");
		page.clickSaveButton();
		Assert.assertTrue(page.getErrorFieldText().contains("at least one category"),
				"Error: categories were selected");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void moveOneCategoryToTheRightTC24(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.moveOneCategoryToTheRight();
		Assert.assertEquals(page.selectedCategoriesField.getText(), "Cat0", "Error: Field is empty");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void moveSeveralCategoriesToTheRightTC25(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.moveOneCategoryToTheRight();
		page.moveOneCategoryToTheRight();
		Assert.assertEquals(page.selectedCategoriesField.getText(), "Cat0\nCat1", "Error: not empty");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyToMoveAllCategoriesToTheRightTC26(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.moveAllCategorieToTheRight();
		Assert.assertTrue(page.availableCategoriesField.getText().isEmpty(), "Error: It's not empty");
		Assert.assertEquals(page.selectedCategoriesField.getText(), "Cat0\nCat1\nCat2\nCat3\nCat4\nCat5",
				"Error: not empty");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyThatCanMoveOneCategoryToTheLeftTC27(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.moveAllCategorieToTheRight();
		page.moveOneCategoryToTheLeft();
		Assert.assertEquals(page.availableCategoriesField.getText(), "Cat0", "Error: empty field");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyThatCanMoveSeveralCategoriesToTheLeftTC28(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.moveAllCategorieToTheRight();
		page.moveOneCategoryToTheLeft();
		page.moveSecondCategoryToTheLeft();
		Assert.assertEquals(page.availableCategoriesField.getText(), "Cat0\nCat1", "Error: empty field");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyThatCanMoveAllCategoriesToTheLeftTC29(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickNewButton();
		page.moveAllCategorieToTheRight();
		page.moveAllCategoriesToTheLeft();
		Assert.assertTrue(page.selectedCategoriesField.getText().isEmpty(), "Error: It's not empty");
		Assert.assertEquals(page.availableCategoriesField.getText(), "Cat0\nCat1\nCat2\nCat3\nCat4\nCat5",
				"Error: not empty");
	}

	@AfterMethod(groups = "NumberFieldTest")
	public void tearDown(ITestResult testResult) throws IOException {
		// if (testResult.getStatus() == ITestResult.FAILURE) {
		// File scrFile = ((TakesScreenshot)
		// driver).getScreenshotAs(OutputType.FILE);
		// String currentDir = System.getProperty("user.dir");
		// String timeStamp = new
		// SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		//
		// FileUtils.copyFile(scrFile, new File("./screenshots/screenshots" +
		// timeStamp + ".png"));
		// }
		driver.close();

	}

	@DataProvider
	public Object[][] browsersAndUrls() {
		return new Object[][] { { "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY },
				{ "http://comments.azurewebsites.net", BrowsersList.CHROME_TEMPORARY },
				// { "http://comments.azurewebsites.net",
				// BrowsersList.IE_TEMPORARY },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY },
				// { "http://commentssprintone.azurewebsites.net/",
				// BrowsersList.IE_TEMPORARY }
		};
	}

	@DataProvider
	public Object[][] browsersAndUrlsAndSymbols() {
		return new Object[][] { { "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "=" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "=" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "/" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "/" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "|" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "|" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "*" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "*" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "(" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "(" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, ")" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, ")" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "_" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "_" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, ":" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, ":" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, ";" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, ";" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "#" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "#" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "%" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "%" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "^" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "^" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "?" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "?" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "[" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "[" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "]" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY, "]" } 
				};

	}

}
