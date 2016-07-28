package com.softserve.edu.magento.pages.customer;

import com.softserve.edu.magento.pages.customer.components.HeaderPanelCustomerAccount;

public class HomePageCustomer extends HeaderPanelCustomerAccount{
 private HomePage homePage;
 public HomePageCustomer() {
	 this.homePage = new HomePage();	 
 }
 public HomePage getHomePage() {
		return homePage;
	}
 
}
