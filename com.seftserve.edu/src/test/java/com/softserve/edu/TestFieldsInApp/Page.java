package com.softserve.edu.TestFieldsInApp;

import java.util.List;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.ExpectedExceptions;

import com.google.common.base.Function;

public class Page {
	WebDriver driver;
	private static String strValue = null;
	private static String strNumber = null;

	private boolean isWebElementFound = false;

	public Page(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(id = "Text")
	WebElement commentTextField;

	@FindBy(id = "Number")
	WebElement numberField;

	@FindBy(name = "SelectedId")
	WebElement check;

	@FindBy(id = "Active")
	WebElement activeCheckButton;

	@FindBy(xpath = "//div[@id='command-navigation']/*[1]")
	WebElement newButton;

	@FindBy(xpath = "//div[@id='command-navigation']/*[3]")
	WebElement editButton;

	@FindBy(xpath = "//div[@id='command-navigation']/*[2]")
	WebElement duplicateButton;

	@FindBy(xpath = ".//*[@id='editor-navigation']/input[2]")
	WebElement saveButton;

	@FindBy(xpath = ".//*[@id='logindisplay']/a")
	WebElement returnButton;

	@FindBy(id = ("Text"))
	WebElement getFieldColor;

	@FindBy(id = ("errorfield"))
	WebElement errorField;

	@FindBy(xpath = "(.//*[@id='Categories'])[1]")
	WebElement cat0;

	@FindBy(xpath = "(.//*[@id='Categories'])[2]")
	WebElement cat1;

	@FindBy(xpath = "(.//*[@id='Categories'])[3]")
	WebElement cat2;

	@FindBy(xpath = "(.//*[@id='Categories'])[4]")
	WebElement cat3;

	@FindBy(xpath = "(.//*[@id='Categories'])[5]")
	WebElement cat4;

	@FindBy(xpath = "(.//*[@id='Categories'])[6]")
	WebElement cat5;

	@FindBy(name = "CurSelect")
	WebElement rightOneCategory;

	@FindBy(name = "CurUnSelectBtn")
	WebElement leftOneCategory;

	@FindBy(name = "AllSelect")
	WebElement rightAllCategories;

	@FindBy(name = "AllUnSelectBtn")
	WebElement leftAllCategories;

	@FindBy(name = "SelectedId")
	WebElement selecFirstCommentFromTheList;

	@FindBy(xpath = "//div[@id='command-navigation']/*[4]")
	WebElement deleteButton;

	@FindBy(id = "selectedCategories")
	WebElement selectedCategoriesField;

	@FindBy(id = "alvailablecategories")
	WebElement availableCategoriesField;

	@FindBy (xpath = "html/body/div[2]/div[3]/div/button[1]")
	WebElement yesButton;

	public static String getStrValue() {
		return strValue;
	}

	public static void setStrValue(String strValue) {
		Page.strValue = strValue;
	}

	public static String getStrNumber() {
		return strNumber;
	}

	public static void setStrNumber(String strNumber) {
		Page.strNumber = strNumber;
	}

	public void visit(String url) {
		driver.get(url);
	}

	public void clickCheckButton() {
		check.click();
	}

	public void clickEditButton() {
		editButton.click();
	}

	public void clickReturnButton() {
		returnButton.click();
	}

	public void clickNewButton() {
		newButton.click();
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public void clickDublicateButton() {
		duplicateButton.click();
	}

	public String getErrorFieldText() {
		return errorField.getText();
	}

	public String getTextFromTheField() {
		strValue = commentTextField.getAttribute("value");
		return strValue;
	}

	public String getNumberFromTheNumberField() {
		strNumber = numberField.getAttribute("value");
		return strNumber;
	}

	public void inputText() {
		commentTextField.sendKeys(strValue);

	}

	public void inputNumber() {
		numberField.sendKeys(strNumber);
	}

	public void pushActiveButton() {
		activeCheckButton.click();
	}

	public void Check0Category() {
		cat0.click();
	}

	public void moveOneCategoryToTheRight() {
		cat0.click();
		rightOneCategory.click();

	}

	public void moveOneCategoryToTheLeft() {
		cat0.click();
		leftOneCategory.click();
	}

	public void moveAllCategorieToTheRight() {
		rightAllCategories.click();
	}

	public void moveAllCategoriesToTheLeft() {
		leftAllCategories.click();
	}

	public void enterDataToCommentTextField(String s) {
		commentTextField.sendKeys(s);
	}

	public void enterDataToNumberField(String s) {
		numberField.sendKeys(s);
	}

	public void clearCommentTextField() {
		commentTextField.clear();
	}

	public void clearNumberField() {
		numberField.clear();
	}

	public void clickActiveButton() {
		activeCheckButton.click();
	}

	public void moveSecondCategoryToTheLeft() {
		cat1.click();
		leftOneCategory.click();
	}
	
	public void clickDeleteButton(){
		deleteButton.click();
	}
	
	public void selecFirstCommentFromTheList(){
		selecFirstCommentFromTheList.click();
	}
	
	public void clickYesButton(){
		yesButton.click();
	}

	public String getCssvalue() {
		String color = getFieldColor.getCssValue("background-color");
		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");

		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3 = Integer.parseInt(hexValue[2]);
		String actualResult = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualResult;

	}

	public boolean findCommentText0InTheList() {
		List<WebElement> comments = null;
		WebElement comment = null;
		while (!isWebElementFound) {
			comments = driver.findElements(By.xpath("//td[contains(text(),'Comment Text 0')]"));
			if (comments.size() > 0) {
				isWebElementFound = true;
				comment = comments.get(0);
			} else {
				List<WebElement> next = driver.findElements(By.linkText(">"));
				if (next.size() > 0) {
					next.get(0).click();
				} else {
					break;
				}
			}
		}
		return isWebElementFound;
	}

	public boolean findCopyCommentText0InTheList() {
		List<WebElement> comments = null;
		WebElement comment = null;
		while (!isWebElementFound) {
			comments = driver.findElements(By.xpath("//td[contains(text(),'Copy of Comment Text 0')]"));
			if (comments.size() > 0) {
				isWebElementFound = true;
				comment = comments.get(0);
			} else {
				List<WebElement> next = driver.findElements(By.linkText(">"));
				if (next.size() > 0) {
					next.get(0).click();
				} else {
					break;
				}
			}
		}
		return isWebElementFound;
	}

	public boolean findUPtO50CharactersElementInTheList() {
		List<WebElement> comments = null;
		WebElement comment = null;
		while (!isWebElementFound) {
			comments = driver.findElements(By.xpath("//td[contains(text(),'zxcvb')]"));
			if (comments.size() > 0) {
				isWebElementFound = true;
				comment = comments.get(0);
			} else {
				List<WebElement> next = driver.findElements(By.linkText(">"));
				if (next.size() > 0) {
					next.get(0).click();
				} else {
					break;
				}
			}
		}
		return isWebElementFound;
	}

	public boolean find50CharactersElementInTheList() {
		List<WebElement> comments = null;
		WebElement comment = null;
		while (!isWebElementFound) {
			comments = driver.findElements(
					By.xpath("//td[contains(text(),'zxcvbnmlkjhgfdsaqwertyuioplkjhgfdsazxcvbnmiuytrewq')]"));
			if (comments.size() > 0) {
				isWebElementFound = true;
				comment = comments.get(0);
			} else {
				List<WebElement> next = driver.findElements(By.linkText(">"));
				if (next.size() > 0) {
					next.get(0).click();
				} else {
					break;
				}
			}
		}
		return isWebElementFound;
	}

	public boolean find1CharacterElementInTheList() {
		List<WebElement> comments = null;
		WebElement comment = null;
		while (!isWebElementFound) {
			comments = driver.findElements(By.xpath("//td[contains(text(),'a')]"));
			if (comments.size() > 0) {
				isWebElementFound = true;
				comment = comments.get(0);
			} else {
				List<WebElement> next = driver.findElements(By.linkText(">"));
				if (next.size() > 0) {
					next.get(0).click();
				} else {
					break;
				}
			}
		}
		return isWebElementFound;
	}

	public void inputTextAndChangeSymbols() {
		StringBuilder sb = new StringBuilder(strValue);
		for (int index = 0; index < sb.length(); index++) {
			char c = sb.charAt(index);
			if (Character.isLowerCase(c)) {
				sb.setCharAt(index, Character.toUpperCase(c));
			} else if (Character.isUpperCase(c)) {
				sb.setCharAt(index, Character.toLowerCase(c));
			} else {
				sb.setCharAt(index, c);
			}

		}
		commentTextField.sendKeys(sb);
	}
}
