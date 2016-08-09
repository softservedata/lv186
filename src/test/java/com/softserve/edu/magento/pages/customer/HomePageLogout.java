package com.softserve.edu.magento.pages.customer;

import com.softserve.edu.magento.pages.customer.components.HeaderPanelLogout;

public class HomePageLogout extends HeaderPanelLogout{
	public HomePage homePage;
	public HomePageLogout () {
		this.homePage = new HomePage();
	}
	//getters
	public HomePage getHomePage() {
		return homePage;
	}
	
}
