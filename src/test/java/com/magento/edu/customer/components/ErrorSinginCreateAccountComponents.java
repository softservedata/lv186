package com.magento.edu.customer.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public  class ErrorSinginCreateAccountComponents {
	private List<WebElement> errorMessage;
	private List<WebElement> errorValidators;
	public ErrorSinginCreateAccountComponents(WebDriver driver) {
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
	//public String getErrorValidatorText(ErrorValidatorName ErrorValidatorName) {
	public String getErrorValidatorText(String validatorFor) {
		int count = 0;
		int index = 0;
		//String validatorFor = ErrorValidatorName.toString();
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
