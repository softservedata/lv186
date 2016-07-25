package com.softserve.edu.magento.editCustomer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract class ACustomPageSideMenu extends ACustomerPageHead {
	protected WebElement custommerView;
	protected WebElement accountInfo;
	protected WebElement adresses;
	protected WebElement orders;
	protected WebElement billingAgreements;
	protected WebElement newsletter;
	protected WebElement productReviews;
	protected WebElement wishlist; 
	protected WebElement changesMade;
	
	protected ACustomPageSideMenu(WebDriver driver){
		super(driver);
		this.custommerView = driver.findElement((By.id("tab_block_customer_edit_tab_view")));
		this.accountInfo = driver.findElement((By.id("tab_customer")));
		this.adresses = driver.findElement((By.id("tab_address")));
		this.orders = driver.findElement((By.id("tab_block_orders")));
		this.billingAgreements = driver.findElement((By.id("tab_block_customer_edit_tab_agreements")));
		this.newsletter = driver.findElement((By.id("tab_block_newsletter")));
		this.productReviews = driver.findElement((By.id("tab_block_reviews")));
		this.wishlist = driver.findElement((By.id("tab_block_wishlist")));
	}
}
