package com.softserve.edu.magento.pages.admin.menu.products;

import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.tools.Search;

public class SuccessProductSavePage extends AddProductPage {

	WebElement successfulProductSaveMessage;

	public SuccessProductSavePage() {
	successfulProductSaveMessage = Search.cssSelector("#messages .message-success:first-child");
	}

	public WebElement getSuccessfulProductSaveMessage() {
		return successfulProductSaveMessage;
	}

	public String getSuccessfulProductSaveMessageText() {
		return getSuccessfulProductSaveMessage().getText().trim();
	}

}
