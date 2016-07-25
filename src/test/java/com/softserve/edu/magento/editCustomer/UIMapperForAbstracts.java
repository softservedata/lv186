package com.softserve.edu.magento.editCustomer;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIMapperForAbstracts {
	
	 HashMap<String, WebElement> abstractLocators;
	 WebDriver driver;
	
	public UIMapperForAbstracts (WebDriver driver){
		this.driver = driver;
		abstractLocators = new HashMap<String, WebElement>();
		abstractLocators.put("back", driver.findElement((By.id("back"))));
		abstractLocators.put("deleteCustomer", driver.findElement((By.id("customer-edit-delete-button"))));
		abstractLocators.put("reset", driver.findElement((By.id("reset"))));
		abstractLocators.put("reset", driver.findElement((By.id("reset"))));
		
	}

	public HashMap<String, WebElement> getAbstractLocators() {
		return abstractLocators;
	}
	

}
