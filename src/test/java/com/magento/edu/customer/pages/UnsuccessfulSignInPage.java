package com.magento.edu.customer.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulSignInPage extends SignInPage {
	
	public static enum MessageErrorSignIn {
		INVALID_SIGNIN("Invalid login or password.");
		//
		private String field;

		private MessageErrorSignIn(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	//-----------------------------------------------
	private WebElement messageError;
	public UnsuccessfulSignInPage(WebDriver driver) {
		super(driver);
		this.messageError = driver.findElement(By.cssSelector("div.message-error.error.message div"));
	}
	public WebElement getMessageError() {
		return messageError;
	}
	public void setMessageError(WebElement messageError) {
		this.messageError = messageError;
	}
	//business logic 
	public String getMessageErrorText() {
		return this.getMessageError().getText();
	}
}
