package com.softserve.edu.magento.data.admin.dashboard;

import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.softserve.edu.magento.pages.admin.menu.sales.CreateOrderFillInformationPage.VALIDATION_MESSAGE;

public class SearchFromRecords {
	public static List<WebElement> getElements(List<WebElement> table, String locator){
		List<WebElement> records = new ArrayList<>();
		for (WebElement webElement : table) {
			records.add(webElement.findElement(By.cssSelector(locator)));
		}
		return records;
	}
	
	public static List<String> getElementsText(List<WebElement> records) {
		List<String> result = new ArrayList<String>();
		for (WebElement webElement : records) {
			result.add(webElement.getText());
		}
		return result;
	}
	private static List<String> getInvalidMessages(List<WebElement> listOfValidationFields) {
		List<String> invalidMessages = new ArrayList<>();
		for (WebElement listOfValidationField : listOfValidationFields) {
			invalidMessages.add(listOfValidationField.getText());
		}
		return invalidMessages;
	}
	public static boolean checkInvalidMessages(List<WebElement> listOfValidationFields){
		List<String> invalidMessages = getInvalidMessages(listOfValidationFields);
		for (String invalidMessage : invalidMessages) {
			if(!invalidMessage.equals(VALIDATION_MESSAGE)){
				return false;
			}
		}
		return true;
	}
}
