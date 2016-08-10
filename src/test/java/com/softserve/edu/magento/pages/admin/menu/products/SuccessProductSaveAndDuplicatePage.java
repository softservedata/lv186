package com.softserve.edu.magento.pages.admin.menu.products;


import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.tools.Search;

public class SuccessProductSaveAndDuplicatePage extends SuccessProductSavePage {

	// Elements

	WebElement successfulProductDuplicate;

	public SuccessProductSaveAndDuplicatePage() {

		successfulProductDuplicate = Search.cssSelector("#messages .message-success:nth-child(2)");
	}

	// Getters

	public WebElement getSuccessfulProductDuplicateMessage() {
		return successfulProductDuplicate;
	}

	public String getSuccessfulProductDuplicateMessageText() {
		return this.getSuccessfulProductDuplicateMessage().getText().trim();
	}
}
