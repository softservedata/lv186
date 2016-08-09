package com.softserve.edu.magento.pages.admin.menu.customers.editCustomer;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.magento.tools.Search;

abstract class ACustomPageSideMenu extends ACustomerPageHead {
	protected WebElement custommerView;
	protected WebElement accountInfo;
	protected WebElement adresses;
	protected WebElement orders;
	protected WebElement billingAgreements;
	protected WebElement newsletter;
	protected WebElement productReviews;
	protected WebElement wishlist; 
	protected List<WebElement> changesMade;
	protected boolean areChangesMade = false;
	
	protected ACustomPageSideMenu(WebDriver driver){
		super(driver);
		this.custommerView = Search.id("tab_block_customer_edit_tab_view");
		this.accountInfo = Search.id("tab_customer");
		this.adresses = Search.id("tab_address");
		this.orders = Search.id("tab_block_orders");
		this.billingAgreements = Search.id("tab_block_customer_edit_tab_agreements");
		this.newsletter = Search.id("tab_block_newsletter");
		this.productReviews = Search.id("tab_block_reviews");
		this.wishlist = Search.id("tab_block_wishlist");
	}
}