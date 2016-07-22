package com.softserve.edu.magento.pages.customer;


import org.openqa.selenium.WebDriver;

import com.softserve.edu.magento.pages.customer.components.ErrorSinginCreateAccountComponents;


public class UnsuccessfulSignInPage extends SignInPage {
	
	public static enum ErrorValidatorName {
		EMAIL("email"),
		PASSWORD("pass");
		;
		//
		private String field;

		private ErrorValidatorName(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	
	public static enum ErrorMessageSignIn {
		INVALID_SIGNIN("Invalid login or password."),
		FIELD_IS_REQUIRED("This is a required field."),
		ERROR_EMAIL_FORMATT("Please enter a valid email address (Ex: johndoe@domain.com).");
		//
		private String field;

		private ErrorMessageSignIn(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	private ErrorSinginCreateAccountComponents  errorSinginComponents;
	public UnsuccessfulSignInPage(WebDriver driver) {
		super(driver);
		this.errorSinginComponents = new ErrorSinginCreateAccountComponents(driver);
	}
	
	/*
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
	}*/
	public ErrorSinginCreateAccountComponents getErrorSinginComponents() {
		return errorSinginComponents;
	}
	public String getErrorMessageText() {
		return this.getErrorSinginComponents().getErrorMessageText();
	}
	public String getErrorValidatorText(ErrorValidatorName ErrorValidatorName) {
		return this.getErrorSinginComponents().getErrorValidatorText(ErrorValidatorName.toString());
	}
}
