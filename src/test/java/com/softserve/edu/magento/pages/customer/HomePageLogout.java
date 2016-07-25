package com.softserve.edu.magento.pages.customer;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.magento.pages.customer.components.HeaderPanelLogout;

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
