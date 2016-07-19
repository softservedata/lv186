package com.magento.edu.customer.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Unsuccessful_CreateAccountPage extends CreateAccountPage{
	public static enum ErrorMessage {
		ALREADY_EXIST_ACCOUNT("There is already an account with this email address."+
	" If you are sure that it is your email address, click here to get your password"+
				" and access your account.");
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
		FIRSTNAME("firstname"),
		LASTNAME("lastname"),
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
	}
	
}
