package com.magento.edu.customer.pages;

import org.openqa.selenium.WebDriver;

import com.magento.edu.customer.components.HeaderPanelLogout;

public class HomePageLogout extends HeaderPanelLogout{
	public HomePage homePage;
	public HomePageLogout (WebDriver driver) {
		super(driver);
		this.homePage = new HomePage(driver);
	}
	//getters
	public HomePage getHomePage() {
		return homePage;
	}
	
}
