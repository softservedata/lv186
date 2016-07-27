package com.softserve.edu.magento.pages.admin.menu.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductExistsPage extends AddProductPage {

	private WebElement productAlreadyExists;

	public ProductExistsPage(WebDriver driver) {
		super(driver);
		productAlreadyExists = driver.findElement(By.cssSelector("messages message-error"));
	}

	// Getters

	public WebElement getProductAlreadyExistsMessage() {
		return this.productAlreadyExists;
	}

	public String getProductAlreadyExistsMessageText() {
		return getProductAlreadyExistsMessage().getText().trim();
	}

}
