package com.softserve.edu.homeTestCase5;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.ExpectedExceptions;

public class Page extends PageBase {
	private static String str = null;

	public Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "SelectedId")
	WebElement check;

	@FindBy(css = "#command-navigation > input:nth-child(3)")
	WebElement editButton;

	@FindBy(id = "Text")
	WebElement commentTextField;

	@FindBy(xpath = ".//*[@id='logindisplay']/a")
	WebElement returnButton;

	@FindBy(xpath = "//div[@id='command-navigation']/*[1]")
	WebElement newButton;

	@FindBy(xpath = "//div[@id='command-navigation']/*[1]")
	WebElement newButton2;

	@FindBy(id = "Text")
	WebElement newCommentTextField;

	@FindBy(xpath = ".//*[@id='editor-navigation']/input[2]")
	WebElement saveButton;

	@FindBy(id = ("Text"))
	WebElement getFieldColor;

	@FindBy(id = ("errorfield"))
	WebElement errorField2;
	
	@FindBy(xpath = "(.//*[@id='Categories'])[1]")
	WebElement cat0;
	
	@FindBy(name = "CurSelect")
	WebElement rightOneCategory;

	// String s =
	// driver.findElement(By.xpath(".//*[@id='Text']")).getCssValue("background-color");
	// System.out.println(s);

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
	public void moveOneCategoryToTheRight() {
		cat0.click();
		rightOneCategory.click();

	}

	public void visit(String url) {
		open(url);
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

	public void clickNewButton2() {
		newButton2.click();
	}

	public void clickSaveButton() {
		saveButton.click();
	}

	public String getErrorFieldText2() {
		return errorField2.getText();
	}

	public String getTextFromTheField() {
		str = commentTextField.getAttribute("value");
		return str;
	}

	public void inputText() {
		newCommentTextField.sendKeys(str);

	}

}
