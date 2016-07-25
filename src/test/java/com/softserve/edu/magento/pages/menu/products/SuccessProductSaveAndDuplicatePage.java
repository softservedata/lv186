package com.softserve.edu.magento.pages.menu.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SuccessProductSaveAndDuplicatePage extends SuccessProductSavePage {

	// Elements

	WebElement successfulProductDuplicate;

	public SuccessProductSaveAndDuplicatePage(WebDriver driver) {
		super(driver);
		successfulProductDuplicate = driver.findElement(By.cssSelector("#messages .message-success:nth-child(2)"));
	}

	// Getters

	public WebElement getSuccessfulProductDuplicateMessage() {
		return successfulProductDuplicate;
	}

	public String getSuccessfulProductDuplicateMessageText() {
		return this.getSuccessfulProductDuplicateMessage().getText().trim();
	}
}
