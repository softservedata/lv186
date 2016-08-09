package com.softserve.edu.magento.pages.customer.components;

import org.openqa.selenium.WebElement;
import com.softserve.edu.magento.tools.Search;

public abstract class Header {
	
	public static enum Titles {
		HOME_PAGE("Home Page"),
		CUSTOMER_LOGIN("Customer Login"),
		CREATE_NEW_CUSTOMER_ACCOUNT("Create New Customer Account"),
		ACCOUNT_DASHBOARD("My Dashboard"),
		ACCOUNT_INFORMATION("Edit Account Information"),
		ADDRESS_BOOK("Add New Address"),
		MY_DOWNLOADABLE_PRODUCTS("My Downloadable Products"),
		MY_ORDERS("My Orders"),
		NEWSLETTER_SUBSCRIPTION("Newsletter Subscription"),
		MY_CREDIT_CARDS("My Credit Cards"),
		MY_PRODUCT_REVIEWS("My Product Reviews"),
		BILLING_AGREEMENTS("Billing Agreements"),
		MY_WISH_LIST("My Wish List"),
		YOU_ARE_SIGNED_OUT("You are signed out");
		//
		private String field;

		private Titles(String field) {
			this.field = field;
		}

		@Override
		public String toString() {
			return this.field;
		}
	}
	//-----------------------------------------------
	//protected WebDriver driver;
	 
	//private WebElement welcomeMessage;
	private WebElement searchField;
	private WebElement cart;
	private WebElement logo;
	private WebElement title;
	 
	 protected Header() {

		 this.searchField = Search.id("search");
		 this.cart = Search.cssSelector("a.action.showcart");
		 this.cart = Search.cssSelector("a.action.showcart");
		 this.logo = Search.className("logo");
		 this.title = Search.className("base");
	 }
// setters


	//public void setWelcomeMessage(WebElement welcomeMessage) {
	//	this.welcomeMessage = welcomeMessage;
	//}

	public void setSearchField(WebElement searchField) {
		this.searchField = searchField;
	}

	public void setCart(WebElement cart) {
		this.cart = cart;
	}

	public void setLogo(WebElement logo) {
		this.logo = logo;
	}
// getters


	//public WebElement getWelcomeMessage() {
	//	return welcomeMessage;
	//}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getCart() {
		return cart;
	}

	public WebElement getLogo() {
		return logo;
	}
	public WebElement getTitle() {
		return title;
	}
// business logic
	//public String getWelcomeText() {
	//	return getWelcomeMessage().getText();
	//}
	public String getSearchText() {
		return getSearchField().getText();
	}
	public String getTitleText() {
		return this.getTitle().getText().trim();
	}
	public void showCart() {
		this.getCart().click();
	}
// business logic do search
	public void typeSearchText(String text) {
		getSearchField().sendKeys(text);
	}
	public void clearSearchText() {
		getSearchField().clear();
	}
	public void search(String text) {
		clearSearchText();
		typeSearchText(text);
		getSearchField().submit();
	}

	 
}
