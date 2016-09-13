
package com.softserve.edu.magento.pages.customer.components;

import java.util.List;
import org.openqa.selenium.WebElement;
import com.softserve.edu.magento.tools.Search;


public  class ErrorSinginCreateAccountComponents {
	private List<WebElement> errorMessage;
	private List<WebElement> errorValidators;
	public ErrorSinginCreateAccountComponents() {
		this.errorMessage = Search.cssSelectors("div.message-error.error.message div");
		this.errorValidators = Search.cssSelectors("div.mage-error");
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
	public boolean isErrorValidator (String validatorFor) {
		boolean isErrorValidator = false;
		for(int i=0;i<errorValidators.size();i++) {
			System.out.println(errorValidators.get(i).getAttribute("for"));
			if( errorValidators.get(i).getAttribute("for").equals(validatorFor) ) {
				if(errorValidators.get(i).isDisplayed()) {
					isErrorValidator = true;
					break;
				}
			}
		}
		return isErrorValidator;
	}
}
