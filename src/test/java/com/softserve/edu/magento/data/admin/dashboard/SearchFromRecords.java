package com.softserve.edu.magento.data.admin.dashboard;

import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
}
