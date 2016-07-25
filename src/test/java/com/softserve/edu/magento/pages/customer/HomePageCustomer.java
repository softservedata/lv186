package com.softserve.edu.magento.pages.customer;

import org.openqa.selenium.WebDriver;

import com.softserve.edu.magento.pages.customer.components.HeaderPanelCustomerAccount;

public class HomePageCustomer extends HeaderPanelCustomerAccount{
 private HomePage homePage;
 public HomePageCustomer(WebDriver driver) {
	 super(driver);
	 this.homePage = new HomePage(driver);	 
 }
 public HomePage getHomePage() {
		return homePage;
	}
 
}
