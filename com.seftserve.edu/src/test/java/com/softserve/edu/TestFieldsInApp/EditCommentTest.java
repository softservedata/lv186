package com.softserve.edu.TestFieldsInApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.TestFieldsInApp.IBrowser.BrowsersList;

public class EditCommentTest {
	private WebDriver driver;
	private Page page;
	BrowsersList browser;

	// @Test(dataProvider = "browsersAndUrls")
	public void testValuesInEditModeTC1(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		Assert.assertTrue(page.getTextFromTheField().equals(page.getStrValue()), "It's  empty");
		Assert.assertTrue(page.getNumberFromTheNumberField().equals(page.getStrNumber()), "It's  empty");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyEmptyCammentTextFieldTC2(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.commentTextField.clear();
		page.clickSaveButton();
		Assert.assertTrue(page.getErrorFieldText().contains("field is required"), "It's  empty");
		Assert.assertEquals(page.getCssvalue(), "#ffeeee", "Error: Another color");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void verifyOneSymbolInCammentTextFieldTC3(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.clearCommentTextField();
		page.enterDataToCommentTextField("a");
		page.clickSaveButton();
		page.clickReturnButton();
		Assert.assertTrue(page.find1CharacterElementInTheList(), "Error, symbol wasn't found");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void entermax50SymbolsInCammentTextFieldTC4(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.clearCommentTextField();
		page.enterDataToCommentTextField("zxcvbnmlkjhgfdsaqwertyuioplkjhgfdsazxcvbnmiuytrewq");
		page.clickSaveButton();
		page.clickReturnButton();
		Assert.assertTrue(page.find50CharactersElementInTheList(), "Error, symbol wasn't found");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void enterMoreThan50SymbolsInCammentTextFieldTC5(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.clearCommentTextField();
		page.enterDataToCommentTextField("zxcvbnmlkjhgfdsaqwertyuioplkjhgfdsazxcvbnmiuytrewqa");
		page.clickSaveButton();
		Assert.assertEquals(page.getErrorFieldText(), "The maximum length of Comment Text field is 50 characters",
				"Error: Another text");
		Assert.assertEquals(page.getCssvalue(), "#ffeeee", "Error: Another color");
	}

	// @Test(dataProvider = "browsersAndUrlsAndSymbols")
	public void enterInvalidSpecialSymbolsInCammentTextFieldTC6(String url, BrowsersList browser, String symbol)
			throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.clearCommentTextField();
		page.enterDataToCommentTextField(symbol);
		page.clickSaveButton();
		Assert.assertEquals(page.getErrorFieldText(),
				"The Comment Text field should contain alphanumeric characters only", "Error: Another text");
		Assert.assertEquals(page.getCssvalue(), "#ffeeee", "Error: Another color");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void canEditCommentTextFieldWithoutNumberTC7(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.clearNumberField();
		page.clickSaveButton();
		page.clickReturnButton();
		Assert.assertTrue(page.findCommentText0InTheList(), "Comment wasn't found");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void enterValueUpTo999ToNumberFieldTC8(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.clearNumberField();
		page.enterDataToNumberField("998");
		page.clickSaveButton();
		page.clickReturnButton();
		Assert.assertTrue(page.findCommentText0InTheList(), "Comment wasn't found");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void enterAlphabeticalValuesToNumberFieldTC9(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.clearNumberField();
		page.enterDataToNumberField("abc");
		page.clickSaveButton();
		Assert.assertEquals(page.getErrorFieldText(), "Number field should contains only digits",
				"Error: Another text");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void enterReservedSymbolsToNumberFieldTC10(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.clearNumberField();
		page.enterDataToNumberField("](?;");
		page.clickSaveButton();
		Assert.assertEquals(page.getErrorFieldText(), "Number field should contains only digits",
				"Error: Another text");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void enter4SymbolsToNumberFieldTC11(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.clearNumberField();
		page.enterDataToNumberField("4896");
		page.clickSaveButton();
		Assert.assertEquals(page.getErrorFieldText(), "The Number field should contain value from 0 to 999",
				"Error: Another text");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void enter4SymbolsToNumberFieldTC12(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.clearNumberField();
		page.enterDataToNumberField("999");
		page.clickSaveButton();
		Assert.assertTrue(page.findCommentText0InTheList(), "Comment wasn't found");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void enterMaxValueToNumberFieldTC13(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.clearNumberField();
		page.enterDataToNumberField("0");
		page.clickSaveButton();
		Assert.assertTrue(page.findCommentText0InTheList(), "Comment wasn't found");
	}

	// Enable
	// @Test(dataProvider = "browsersAndUrls")
	public void enterUniqueNumberToNumberFieldTC14(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.getNumberFromTheNumberField();
		page.clickReturnButton();
		page.clickCheckButton();
		page.clickEditButton();
		page.clearNumberField();
		page.inputNumber();
		page.clickSaveButton();
		Assert.assertEquals(page.getErrorFieldText(), "Number field should be unique of empty", "Error: Another text");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void checkActiveBoxTC15(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.clickActiveButton();
		page.clickActiveButton();
		Assert.assertTrue(page.activeCheckButton.isDisplayed(), "Error: Check isn't displayed");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void categoryNotEmptyValidationInEditModeTC16(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.moveAllCategoriesToTheLeft();
		page.clickSaveButton();
		Assert.assertEquals(page.getErrorFieldText(), "Please, select at least one category", "Error: Another Text");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void moveOneCategoryToTheRightTC17(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.moveOneCategoryToTheRight();
		Assert.assertEquals(page.selectedCategoriesField.getText(), "Cat0\nCat1", "Error: Field is empty");

	}

	// @Test(dataProvider = "browsersAndUrls")
	public void moveTwoCategoriesToTheRightTC18(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.moveOneCategoryToTheRight();
		page.moveOneCategoryToTheRight();
		Assert.assertEquals(page.selectedCategoriesField.getText(), "Cat0\nCat1\nCat2", "Error: Field is empty");

	}

	// @Test(dataProvider = "browsersAndUrls")
	public void moveAllCategoriesToTheRightTC19(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.moveAllCategorieToTheRight();
		Assert.assertTrue(page.availableCategoriesField.getText().isEmpty(), "Error: It's not empty");
		Assert.assertEquals(page.selectedCategoriesField.getText(), "Cat0\nCat1\nCat2\nCat3\nCat4\nCat5",
				"Error: not empty");

	}

	// @Test(dataProvider = "browsersAndUrls")
	public void moveOneCategoryToTheLeftTC20(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.moveAllCategorieToTheRight();
		page.moveOneCategoryToTheLeft();
		Assert.assertEquals(page.availableCategoriesField.getText(), "Cat0", "Error: empty field");
	}

	// @Test(dataProvider = "browsersAndUrls")
	public void moveTwoCategoryToTheLeftTC21(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.moveAllCategorieToTheRight();
		page.moveOneCategoryToTheLeft();
		page.moveSecondCategoryToTheLeft();
		Assert.assertEquals(page.availableCategoriesField.getText(), "Cat0\nCat1", "Error: empty field");
	}

	@Test(dataProvider = "browsersAndUrls")
	public void moveAllCategoryToTheLeftTC22(String url, BrowsersList browser) throws Exception {
		driver = browser.getWebDriver();
		page = PageFactory.initElements(driver, Page.class);
		page.visit(url);
		page.clickCheckButton();
		page.clickEditButton();
		page.moveAllCategorieToTheRight();
		page.moveAllCategoriesToTheLeft();
		Assert.assertTrue(page.selectedCategoriesField.getText().isEmpty(), "Error: It's not empty");
		Assert.assertEquals(page.availableCategoriesField.getText(), "Cat0\nCat1\nCat2\nCat3\nCat4\nCat5",
				"Error: not empty");
	}

	@AfterMethod()
	public void tearDown() {
		driver.close();

	}

	@DataProvider
	public Object[][] browsersAndUrls() {
		return new Object[][] { { "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY },
				{ "http://comments.azurewebsites.net", BrowsersList.CHROME_TEMPORARY },
				{ "http://comments.azurewebsites.net", BrowsersList.IE_TEMPORARY },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.CHROME_TEMPORARY },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.IE_TEMPORARY } };
	}

	@DataProvider
	public Object[][] browsersAndUrlsAndSymbols() {
		return new Object[][] { { "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "=" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, "=" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "/" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, "/" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "|" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, "|" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "*" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, "*" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "(" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, "(" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, ")" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, ")" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "_" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, "_" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, ":" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, ":" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, ";" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, ";" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "#" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, "#" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "%" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, "%" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "^" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, "^" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "?" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, "?" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "[" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, "[" },
				{ "http://comments.azurewebsites.net", BrowsersList.FIREFOX_TEMPORARY, "]" },
				{ "http://commentssprintone.azurewebsites.net/", BrowsersList.FIREFOX_TEMPORARY, "]" } };

	}

}
