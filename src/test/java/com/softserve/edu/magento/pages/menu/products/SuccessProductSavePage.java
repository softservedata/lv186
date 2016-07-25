package com.softserve.edu.magento.pages.menu.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessProductSavePage extends AddProductPage {

	// Elements

	WebElement successfulProductSaveMessage;

	public SuccessProductSavePage(WebDriver driver) {
		super(driver);
		successfulProductSaveMessage = driver.findElement(By.cssSelector("#messages .message-success:first-child"));
	}

	// Getters

	public WebElement getSuccessfulProductSaveMessage() {
		return successfulProductSaveMessage;
	}

	public String getSuccessfulProductSaveMessageText() {
		return getSuccessfulProductSaveMessage().getText().trim();
	}

	// Business Logic

	public SuccessProductSavePage gotoSuccessProductSavePage() {
		clickSaveButton();
		return new SuccessProductSavePage(driver);
	}
}
