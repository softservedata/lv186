package com.softserve.edu.homeTestCase6;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page extends PageBase {
	private static String str = null;

	public Page(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//tbody/tr[1]/td[1]/input[1]")
	WebElement check;

	@FindBy(xpath = ".//*[@id='command-navigation']/input[2]")
	WebElement editButton;

	@FindBy(id = "Text")
	WebElement commentTextField;

	@FindBy(xpath = ".//*[@id='logindisplay']/a")
	WebElement returnButton;

	@FindBy(xpath = "//div[@id='command-navigation']/*[1]")
	WebElement newButton;

	@FindBy(id = "Text")
	WebElement newCommentTextField;

	@FindBy(xpath = ".//*[@id='editor-navigation']/input[2]")
	WebElement saveButton;

	@FindBy(id = ("Text"))
	WebElement getFieldColor;

	@FindBy(id = ("errorfield"))
	WebElement errorField2;

	@FindBy(name = "CurSelect")
	WebElement rightOneCategory;

	@FindBy(xpath = "(.//*[@id='Categories'])[1]")
	WebElement cat0;

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

	public void inputTextAndChangeSymbols() {
		StringBuilder sb = new StringBuilder(str);
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
		newCommentTextField.sendKeys(sb);
	}

}
