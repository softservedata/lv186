package com.softserve.edu.magento.pages.customer;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.magento.pages.customer.components.ErrorSinginCreateAccountComponents;

public class Unsuccessful_CreateAccountPage extends CreateAccountPage{
	public static enum ErrorMessage {
		ALREADY_EXIST_ACCOUNT("There is already an account with this email address."+
	" If you are sure that it is your email address, click here to get your password"+
				" and access your account."),
		PASSWORDS_IS_NOT_THE_SAME("Please enter the same value again."),
		ERROR_PASSWORD_FORMAT("Minimum of different classes of characters"+
		" in password is 3. Classes of characters: Lower Case, Upper Case,"+
				" Digits, Special Characters."),
		FIELD_IS_REQUIRED("This is a required field.");
		//
		private String field;

		private ErrorMessage(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	public static enum ErrorValidatorName {
		EMAIL("email_address"),
		PASSWORD("password"),
		CONFIRMPASSWORD("password-confirmation"),
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
	private ErrorSinginCreateAccountComponents errorCreateAccountComponents;
	public Unsuccessful_CreateAccountPage(WebDriver driver) {
		super(driver);
		this.errorCreateAccountComponents = new ErrorSinginCreateAccountComponents(driver);
	}
	public ErrorSinginCreateAccountComponents getErrorCreateAccountComponents() {
		return errorCreateAccountComponents;
	}
	public String getErrorMessageText() {
		return this.getErrorCreateAccountComponents().getErrorMessageText();
	}
	public String getErrorValidatorText(ErrorValidatorName ErrorValidatorName) {
		return this.getErrorCreateAccountComponents().getErrorValidatorText(ErrorValidatorName.toString());
	}
	 /*
	private List<WebElement> errorMessage;
	private List<WebElement> errorValidators;
	public Unsuccessful_CreateAccountPage(WebDriver driver) {
		super(driver);
		this.errorMessage = driver.findElements(By.cssSelector("div.message-error.error.message div"));
		this.errorValidators = driver.findElements(By.className("mage-error"));
	}
	public List<WebElement> getErrorMessage() {
		return errorMessage;
	}
	public String getErrorMessageText() {
		if( errorMessage.size() > 0 ) {
			return errorMessage.get(0).getText().toString();
		} else {
			return null;
		}
	}
	public List<WebElement> getErrorValidators() {
		return errorValidators;
	}
	public String getErrorValidatorText(ErrorValidatorName ErrorValidatorName) {
		int count = 0;
		int index = 0;
		String validatorFor = ErrorValidatorName.toString();
		for(int i=0;i<errorValidators.size();i++) {
			if( errorValidators.get(i).getAttribute("for").equals(validatorFor) ) {
				count++;
				index = i;
				break;
			}
		}
		if( count > 0 ) {
			return errorValidators.get(index).getText();
		} else {
			return null;
		}
	}*/
	
}
