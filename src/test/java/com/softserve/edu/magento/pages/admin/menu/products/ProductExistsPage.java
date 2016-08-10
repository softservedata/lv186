package com.softserve.edu.magento.pages.admin.menu.products;


import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.tools.Search;

public class ProductExistsPage extends AddProductPage {

	private WebElement productAlreadyExists;

	public ProductExistsPage() {

		productAlreadyExists = Search.cssSelector("messages message-error");
	}

	// Getters

	public WebElement getProductAlreadyExistsMessage() {
		return this.productAlreadyExists;
	}

	public String getProductAlreadyExistsMessageText() {
		return getProductAlreadyExistsMessage().getText().trim();
	}

}
